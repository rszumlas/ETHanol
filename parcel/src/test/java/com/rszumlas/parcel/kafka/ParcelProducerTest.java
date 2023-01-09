package com.rszumlas.parcel.kafka;

import com.rszumlas.clients.parceldone.ParcelDoneRequest;
import com.rszumlas.parcel.Parcel;
import com.rszumlas.parcel.ParcelService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.kafka.core.KafkaTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class ParcelProducerTest {

    @Mock
    private KafkaTemplate<String, Parcel> kafkaTemplate;
    @Captor
    private ArgumentCaptor<Parcel> parcelArgumentCaptor;
    @Captor
    private ArgumentCaptor<String> stringArgumentCaptor;
    private ParcelProducer underTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        underTest = new ParcelProducer(kafkaTemplate);
    }

    @Test
    void itShouldSendMessage() {
        // Given
        String expectedTopic = "parcel_topic";
        Parcel event = new Parcel();

        // When
        underTest.sendMessage(event);

        // Then
        then(kafkaTemplate).should().send(stringArgumentCaptor.capture(), parcelArgumentCaptor.capture());
        String topicArgumentCaptorValue = stringArgumentCaptor.getValue();
        Parcel parcelArgumentCaptorValue = parcelArgumentCaptor.getValue();

        verify(kafkaTemplate, times(1)).send(topicArgumentCaptorValue, parcelArgumentCaptorValue);
        assertEquals(expectedTopic, topicArgumentCaptorValue);
        assertThat(parcelArgumentCaptorValue)
                .usingRecursiveComparison()
                .isEqualTo(event);
    }
}