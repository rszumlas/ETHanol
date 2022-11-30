package com.rszumlas.account;

import com.rszumlas.clients.account.AccountRequest;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Setter
@AllArgsConstructor
@RequestMapping("api/v1/account")
@RestController
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public void insertAccount(@RequestBody AccountRequest accountRequest) {
        accountService.insertAccount(accountRequest);
    }

    @PutMapping(path = "{account_id}/{eth_earned}")
    public void updateEthTotal(@PathVariable("account_id") Long account_id,
                               @PathVariable("eth_earned") Double eth_earned) {
        accountService.updateEthTotal(account_id, eth_earned);
    }


}
