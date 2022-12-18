package com.rszumlas.clients.account;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        contextId = "accountContextId",
        name = "account",
        url = "${clients.account.url}"
)
public interface AccountClient {

    @PostMapping(path = "api/v1/account")
    void insertAccount(@RequestBody AccountRequest accountRequest);

    @GetMapping(path = "api/v1/account/{email}/{password}")
    boolean doesEmailAndPasswordExist(@PathVariable("email") String email,
                                      @PathVariable("password") String password);

}
