package com.rszumlas.account;

import com.rszumlas.account.exception.ApiRequestException;
import com.rszumlas.clients.account.AccountRequest;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final EmailValidator emailValidator;

    public void insertAccount(AccountRequest accountRequest) {

        if (!emailValidator.test(accountRequest.email())) {
            throw new ApiRequestException(accountRequest.email() + " is not valid");
        }

        if (accountRepository.isEmailTaken(accountRequest.email())) {
            throw new ApiRequestException(accountRequest.email() + " is taken");
        }

        accountRepository.insertAccount(accountRequest);
    }

    public void updateEthTotal(AccountRequest accountRequest) {
        accountRepository.updateEthTotal(accountRequest.id(), accountRequest.eth_total());
    }

    public boolean doesEmailAndPasswordExist(String email, String password) {
        return accountRepository.doesEmailAndPasswordExist(email, password);
    }

}
