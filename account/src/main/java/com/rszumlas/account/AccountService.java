package com.rszumlas.account;

import com.rszumlas.clients.parceldone.ParcelDoneClient;
import com.rszumlas.clients.parceldone.ParcelDoneRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.DoubleBinaryOperator;

@Service
@AllArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public void updateEthTotal(Long account_id, Double eth_earned) {
        accountRepository.updateEthTotal(account_id, eth_earned);
    }

}
