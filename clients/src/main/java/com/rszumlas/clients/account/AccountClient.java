package com.rszumlas.clients.account;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        contextId = "accountContextId",
        name = "account",
        url = "${clients.account.url}"
)
public interface AccountClient {

    @PostMapping(path = "api/v1/account")
    void insertAccount(@RequestBody AccountRequest accountRequest);

    @PutMapping(path = "api/v1/account/{account_id}/{eth_earned}")
    void updateEthTotal(@PathVariable("account_id") Long account_id,
                        @PathVariable("eth_earned") Double eth_earned);

}
