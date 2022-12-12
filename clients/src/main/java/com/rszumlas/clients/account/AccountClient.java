package com.rszumlas.clients.account;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path = "api/v1/account/{email}/{password}")
    public boolean doesEmailAndPasswordExist(@PathVariable("email") String email,
                                             @PathVariable("password") String password);

}
