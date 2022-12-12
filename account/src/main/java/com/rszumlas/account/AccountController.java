package com.rszumlas.account;

import com.rszumlas.clients.account.AccountRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Does email and passowrd exist",
            description = "Checks if account with given email and password exists")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Account exists",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(type = "boolean"))
            })
    })
    @GetMapping(path = "{email}/{password}")
    public boolean doesEmailAndPasswordExist(@Parameter(description = "E-mail of account to be checked") @PathVariable("email") String email,
                                             @Parameter(description = "Password of account to be checked") @PathVariable("password") String password) {
        return accountService.doesEmailAndPasswordExist(email, password);
    }


}
