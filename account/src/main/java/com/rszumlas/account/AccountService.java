package com.rszumlas.account;

import com.rszumlas.clients.parceldone.ParcelDoneClient;
import com.rszumlas.clients.parceldone.ParcelDoneRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final ParcelDoneClient parcelDoneClient;

    public void updateEthTotal(Long account_id) {
        Double eth_total = parcelDoneClient.findParcelDoneByAccountId(account_id)
                .get().eth_earned();
        accountRepository.updateEthTotal(account_id, eth_total);
    }

}
