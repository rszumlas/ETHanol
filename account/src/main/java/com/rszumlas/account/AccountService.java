package com.rszumlas.account;

import com.rszumlas.account.exception.ApiRequestException;
import com.rszumlas.clients.account.AccountRequest;
import com.rszumlas.clients.parcel.ParcelRequest;
import com.rszumlas.clients.parceldone.ParcelDoneRequest;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@AllArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final EmailValidator emailValidator;
    public static final Logger LOGGER = LoggerFactory.getLogger(AccountService.class);


    // insertAccount
    public void insertAccount(AccountRequest accountRequest) {
        throwIfEmailNotValidOrTaken(accountRequest);
        accountRepository.insertAccount(accountRequest);
    }

    private void throwIfEmailNotValidOrTaken(AccountRequest accountRequest) {
        if (!emailValidator.test(accountRequest.email())) {
            throw new ApiRequestException(accountRequest.email() + " is not valid");
        }
        if (accountRepository.isEmailTaken(accountRequest.email())) {
            throw new ApiRequestException(accountRequest.email() + " is taken");
        }
    }

    // updateEthTotal
    public void updateEthTotal(ParcelDoneRequest parcelDoneRequest) {
        Boolean is_finished = parcelDoneRequest.is_finished();
        if (is_finished) {
            Double eth_earned = calculateEarnedEth(parcelDoneRequest.delivery_time_seconds());
            LOGGER.info(String.format("Increase eth amount by %s", eth_earned));
            accountRepository.updateEthTotal(parcelDoneRequest.account_id(), eth_earned);
        }
    }

    private Double calculateEarnedEth(Integer delivery_time_seconds) {
        float plnPerHour = 19.7f;
        int ethPriceInUsd = 1300;
        double usdPerSecond = plnPerHour/4.5 / 3600;
        double ethPerSecond = usdPerSecond/ethPriceInUsd;
        BigDecimal earnedEth = BigDecimal.valueOf(ethPerSecond * delivery_time_seconds).setScale(4, RoundingMode.DOWN);
        return earnedEth.doubleValue();
    }

    // doesEmailAndPasswordExist
    public boolean doesEmailAndPasswordExist(String email, String password) {
        return accountRepository.doesEmailAndPasswordExist(email, password);
    }

}
