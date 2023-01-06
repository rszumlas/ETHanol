package com.rszumlas.account;

import com.rszumlas.account.exception.ApiRequestException;
import com.rszumlas.account.util.EmailValidator;
import com.rszumlas.clients.account.AccountRequest;
import com.rszumlas.clients.parceldone.ParcelDoneRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;
    @Mock
    private EmailValidator emailValidator;
    @Captor
    private ArgumentCaptor<Long> longArgumentCaptor;
    @Captor
    private ArgumentCaptor<Double> doubleArgumentCaptor;
    @Captor
    private ArgumentCaptor<String> stringArgumentCaptor;
    @Captor
    private ArgumentCaptor<AccountRequest> accountRequestArgumentCaptor;
    private AccountService underTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        underTest = new AccountService(accountRepository, emailValidator);
    }

    // insertAccount
    @Test
    void itShouldInsertAccount() {
        // Given
        AccountRequest accountRequest = new AccountRequest("aaa@gmail.com", "aaa", 0.5);
        given(emailValidator.test(accountRequest.email())).willReturn(true);

        // When
        underTest.insertAccount(accountRequest);

        // Then
        then(accountRepository).should().insertAccount(accountRequestArgumentCaptor.capture());
        AccountRequest accountRequestArgumentCaptorValue = accountRequestArgumentCaptor.getValue();
        assertThat(accountRequestArgumentCaptorValue)
                .usingRecursiveComparison()
                .isEqualTo(accountRequest);
    }

    @Test
    void itShouldThrowIfEmailNotValid() {
        // Given
        AccountRequest accountRequest = new AccountRequest("aaagmail.com", "Gshgxb7d8", 0.1111);

        // When
        // Then
        assertThatThrownBy(() -> underTest.throwIfEmailNotValidOrTaken(accountRequest.email()))
                .isInstanceOf(ApiRequestException.class)
                .hasMessageContaining(accountRequest.email() + " is not valid");
    }

    @Test
    void itShouldThrowIfEmailIsTaken() {
        // Given
        AccountRequest accountRequest = new AccountRequest("aaa@gmail.com", "Gshgxb7d8", 0.1111);
        String email = accountRequest.email();
        given(emailValidator.test(email)).willReturn(true);
        given(accountRepository.isEmailTaken(email)).willReturn(true);

        // When
        // Then
        assertThatThrownBy(() -> underTest.throwIfEmailNotValidOrTaken(email))
                .isInstanceOf(ApiRequestException.class)
                .hasMessageContaining(accountRequest.email() + " is taken");
    }

    // updateEthTotal
    @Test
    void itShouldUpdateEthTotal() {
        // Given
        ParcelDoneRequest parcelDoneRequest = new ParcelDoneRequest(
                1L,
                1L,
                7200,
                true
        );

        // When
        underTest.updateEthTotal(parcelDoneRequest);

        // Then
        then(accountRepository).should().updateEthTotal(longArgumentCaptor.capture(), doubleArgumentCaptor.capture());
        Long longArgumentCaptorValue = longArgumentCaptor.getValue();
        Double doubleArgumentCaptorValue = doubleArgumentCaptor.getValue();

        assertEquals(1L, longArgumentCaptorValue);
        assertEquals(0.0067, doubleArgumentCaptorValue);
    }

    @Test
    void itShouldCalculateEarnedEth() {
        // Given
        Integer delivery_time_seconds = 7200;
        Double expectedEth = 0.0067;

        // When
        Double actualEth = underTest.calculateEarnedEth(delivery_time_seconds);

        // Then
        assertEquals(expectedEth, actualEth);
    }

    // doesEmailAndPasswordExist
    @Test
    void itShouldCheckIfEmailAndPasswordExist() {
        // Given
        String email = "aaa@gmail.com";
        String password = "aaa";

        // When
        underTest.doesEmailAndPasswordExist(email, password);

        // Then
        then(accountRepository).should().doesEmailAndPasswordExist(stringArgumentCaptor.capture(), stringArgumentCaptor.capture());
        String emailArgumentCaptorValue = stringArgumentCaptor.getAllValues().get(0);
        String passwordArgumentCaptorValue = stringArgumentCaptor.getAllValues().get(1);
        assertEquals(email, emailArgumentCaptorValue);
        assertEquals(password, passwordArgumentCaptorValue);
    }
}