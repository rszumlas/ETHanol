package com.rszumlas.account;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Setter
@AllArgsConstructor
@RequestMapping("api/v1/account")
@RestController
public class AccountController {

    private final AccountService accountService;

    @PutMapping(path = "{account_id}/{eth_earned}")
    public void updateEthTotal(@PathVariable("account_id") Long account_id,
                               @PathVariable("eth_earned") Double eth_earned) {
        accountService.updateEthTotal(account_id, eth_earned);
    }


}
