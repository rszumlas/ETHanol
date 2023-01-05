package com.rszumlas.account;

import com.rszumlas.account.exception.ApiRequestException;
import com.rszumlas.account.util.EmailValidator;
import com.rszumlas.clients.account.AccountRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;
    @Mock
    private EmailValidator emailValidator;
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
    void itShouldThrowIfEmailNotValid() {
        // Given
        AccountRequest accountRequest = new AccountRequest("kubagmail.com", "Gshgxb7d8", 0.1111);

        // When
        // Then
        assertThatThrownBy(() -> underTest.throwIfEmailNotValidOrTaken(accountRequest.email()))
                .isInstanceOf(ApiRequestException.class)
                .hasMessageContaining(accountRequest.email() + " is not valid");
    }
    @Test
    void itShouldThrowIfEmailIsTaken() {
        // Given
        AccountRequest accountRequest = new AccountRequest("kuba@gmail.com", "Gshgxb7d8", 0.1111);
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

        // When

        // Then

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
    void itShouldDoesEmailAndPasswordExist() {
        // Given
        // When
        // Then
    }
}