package com.rszumlas.account.kafka;

import com.rszumlas.account.AccountService;
import com.rszumlas.clients.account.AccountRequest;
import com.rszumlas.clients.parceldone.ParcelDoneRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class AccountConsumerTest {

    @Mock
    private AccountService accountService;
    @Captor
    private ArgumentCaptor<ParcelDoneRequest> parcelDoneRequestArgumentCaptor;
    private AccountConsumer underTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        underTest = new AccountConsumer(accountService);
    }

    @Test
    void itShouldConsume() {
        // Given
        ParcelDoneRequest event = new ParcelDoneRequest(1L, 1L, 7200, true);

        // When
        underTest.consume(event);

        // Then
        then(accountService).should().updateEthTotal(parcelDoneRequestArgumentCaptor.capture());
        ParcelDoneRequest parcelDoneRequestArgCaptorValue = parcelDoneRequestArgumentCaptor.getValue();

        verify(accountService, times(1)).updateEthTotal(event);
        assertThat(parcelDoneRequestArgCaptorValue)
                .usingRecursiveComparison()
                .isEqualTo(event);
    }
}