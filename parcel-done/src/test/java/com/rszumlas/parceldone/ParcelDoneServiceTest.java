package com.rszumlas.parceldone;

import com.rszumlas.account.Account;
import com.rszumlas.clients.parceldone.ParcelDoneRequest;
import com.rszumlas.parcel.Parcel;
import com.rszumlas.parcel.ParcelService;
import com.rszumlas.parceldone.kafka.ParcelDoneRequestProducer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class ParcelDoneServiceTest {

    @Mock
    private ParcelDoneRepository parcelDoneRepository;
    @Mock
    private ParcelDoneRequestProducer parcelDoneRequestProducer;
    @Captor
    private ArgumentCaptor<ParcelDone> parcelDoneArgumentCaptor;
    private ParcelDoneService underTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        underTest = new ParcelDoneService(parcelDoneRepository, parcelDoneRequestProducer);
    }

    @Test
    void itShouldCheckIfFinished() {
        // Given
        Long parcel_id = 1L;
        given(parcelDoneRepository.checkIfFinished(parcel_id)).willReturn(true);

        // When
        Boolean is_finished = underTest.checkIfFinished(parcel_id);

        // Then
        assertEquals(true, is_finished);
    }

    @Test
    void itShouldSaveParcelDone() {
        // Given
        ParcelDoneRequest parcelDoneRequest = new ParcelDoneRequest(1L, 1L, 777, true);
        ParcelDone expectedParcelDone = new ParcelDone(
                null,
                new Parcel(parcelDoneRequest.parcel_id()),
                new Account(parcelDoneRequest.account_id()),
                parcelDoneRequest.delivery_time_seconds(),
                parcelDoneRequest.is_finished()
        );

        // When
        underTest.saveParcelDone(parcelDoneRequest);

        // Then
        then(parcelDoneRepository).should().save(parcelDoneArgumentCaptor.capture());
        ParcelDone parcelDoneArgCaptorValue = parcelDoneArgumentCaptor.getValue();

        assertThat(parcelDoneArgCaptorValue)
                .usingRecursiveComparison()
                .isEqualTo(expectedParcelDone);
        verify(parcelDoneRequestProducer, times(1)).sendMessage(parcelDoneRequest);
    }
}