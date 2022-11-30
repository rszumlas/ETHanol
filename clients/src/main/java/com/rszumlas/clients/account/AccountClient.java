package com.rszumlas.clients.account;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(
        contextId = "accountContextId",
        name = "account",
        url = "${clients.account.url}"
)
public interface AccountClient {

    @PutMapping(path = "api/v1/account/{account_id}/{eth_earned}")
    void updateEthTotal(@PathVariable("account_id") Long account_id,
                        @PathVariable("eth_earned") Double eth_earned);

}
