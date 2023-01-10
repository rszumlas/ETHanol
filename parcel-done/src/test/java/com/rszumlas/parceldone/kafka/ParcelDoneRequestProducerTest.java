package com.rszumlas.parceldone.kafka;

import com.rszumlas.clients.parceldone.ParcelDoneRequest;
import com.rszumlas.parcel.Parcel;
import com.rszumlas.parcel.kafka.ParcelProducer;
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

class ParcelDoneRequestProducerTest {

    @Mock
    private KafkaTemplate<String, ParcelDoneRequest> kafkaTemplate;
    @Captor
    private ArgumentCaptor<String> stringArgumentCaptor;
    @Captor
    private ArgumentCaptor<ParcelDoneRequest> parcelDoneRequestArgCaptor;
    private ParcelDoneRequestProducer underTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        underTest = new ParcelDoneRequestProducer(kafkaTemplate);
    }

    @Test
    void itShouldSendMessage() {
        // Given
        String expectedTopic = "parcel_done_request_topic";
        ParcelDoneRequest event = new ParcelDoneRequest(null, null, null, null);

        // When
        underTest.sendMessage(event);

        // Then
        then(kafkaTemplate).should().send(stringArgumentCaptor.capture(), parcelDoneRequestArgCaptor.capture());
        String topicArgumentCaptorValue = stringArgumentCaptor.getValue();
        ParcelDoneRequest parcelDoneRequestArgCaptorValue = parcelDoneRequestArgCaptor.getValue();

        verify(kafkaTemplate, times(1)).send(topicArgumentCaptorValue, parcelDoneRequestArgCaptorValue);
        assertEquals(expectedTopic, topicArgumentCaptorValue);
        assertThat(parcelDoneRequestArgCaptorValue)
                .usingRecursiveComparison()
                .isEqualTo(event);
    }
}