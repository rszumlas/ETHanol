package com.rszumlas.parcel;

import com.rszumlas.clients.parcel.ParcelRequest;
import com.rszumlas.parcel.kafka.ParcelProducer;
import com.rszumlas.vodka.Vodka;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class ParcelServiceTest {

    @Mock
    private ParcelRepository parcelRepository;
    @Mock
    private ParcelProducer parcelProducer;
    @Captor
    private ArgumentCaptor<Parcel> parcelArgumentCaptor;
    private ParcelService underTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        underTest = new ParcelService(parcelRepository, parcelProducer);
    }

    @Test
    void itShouldFindParcelById() {
        // Given
        Long parcel_id = 1L;
        given(parcelRepository.findById(parcel_id)).willReturn(Optional.of(new Parcel()));

        // When
        Parcel parcel = underTest.findParcelById(parcel_id);

        // Then
        verify(parcelRepository, times(1)).findById(parcel_id);
    }

    @Test
    void itShouldInsertParcel() {
        // Given
        ParcelRequest parcelRequest = new ParcelRequest("IMPORT", 10, 1L, LocalDateTime.now());
        Parcel expectedParcel = new Parcel(
                null,
                parcelRequest.delivery_type(),
                new Vodka(parcelRequest.vodka_id()),
                parcelRequest.crates(),
                parcelRequest.created_at()
        );

        // When
        underTest.insertParcel(parcelRequest);

        // Then
        then(parcelRepository).should().saveAndFlush(parcelArgumentCaptor.capture());
        Parcel parcelArgumentCaptorValue = parcelArgumentCaptor.getValue();

        assertThat(parcelArgumentCaptorValue)
                .usingRecursiveComparison()
                .isEqualTo(expectedParcel);
        verify(parcelProducer, times(1)).sendMessage(parcelArgumentCaptorValue);
    }
}