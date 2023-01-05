package com.rszumlas.account;

import com.rszumlas.clients.account.AccountRequest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class AccountRepositoryTest {

    @Autowired
    private AccountRepository underTest;
    public static final Logger LOGGER = LoggerFactory.getLogger(AccountRepositoryTest.class);

    @Test
    void itShouldInsertAccount() {
        // Given
        AccountRequest accountRequest = new AccountRequest(
                "GdfAADf@gmail.com",
                "GdfAADf",
                0.2222
        );

        // When
        underTest.insertAccount(accountRequest);

        // Then
        Optional<Account> accountFound = underTest.findByEmail(accountRequest.email());
        assertThat(accountFound)
                .isPresent()
                .hasValueSatisfying(a -> {
            assertThat(a.getEmail()).isEqualTo("GdfAADf@gmail.com");
            assertThat(a.getPassword()).isEqualTo("GdfAADf");
            assertThat(a.getEth_total()).isEqualTo(0.2222);
        });
    }

    @Test
    void itShouldUpdateEthTotal() {
        // Given
        Account account = new Account(
                1L,
                "Gh23r1hr217@gmail.com",
                "Gh23r1hr217",
                0.0
        );
        Double eth_earned = 0.1111;

        // When
        underTest.saveAndFlush(account);
        underTest.updateEthTotal(account.getId(), eth_earned);

        // Then
        Optional<Account> accountFound = underTest.findById(account.getId());

        assertThat(accountFound)
                .isPresent()
                .hasValueSatisfying(a -> {
                    assertThat(a.getEth_total())
                            .isEqualTo(account.getEth_total() + eth_earned);
                });
    }

    @Test
    void itShouldCheckIsEmailTaken() {
        // Given
        Account account = new Account(
                1L,
                "AFGoamfq25@gmail.com",
                "AFGoamfq25",
                0.0
        );

        // When
        underTest.save(account);

        // Then
        assertThat(underTest.isEmailTaken("AFGoamfq25@gmail.com"))
                .isTrue();
    }

    @Test
    void itShouldCheckDoesEmailAndPasswordExist() {
        // Given
        Account account = new Account(
                1L,
                "AFGoamfq25@gmail.com",
                "AFGoamfq25",
                0.0
        );

        // When
        underTest.save(account);

        // Then
        assertThat(underTest.doesEmailAndPasswordExist("AFGoamfq25@gmail.com", "AFGoamfq25"))
                .isTrue();
    }

}