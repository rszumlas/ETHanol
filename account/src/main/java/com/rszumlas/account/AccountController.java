package com.rszumlas.account;

import com.rszumlas.clients.parcel.ParcelRequest;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Setter
@AllArgsConstructor
@RequestMapping("api/v1/account")
@RestController
public class AccountController {

    private final AccountService accountService;

    @PatchMapping(path = "{account_id}")
    public void updateEthTotal(@PathVariable("account_id") Long account_id) {
        accountService.updateEthTotal(account_id);
    }


}
