package com.rszumlas.account;

import com.rszumlas.clients.account.AccountRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@AllArgsConstructor
@RequestMapping("api/v1/account")
@RestController
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public void insertAccount(@RequestBody AccountRequest accountRequest) {
        accountService.insertAccount(accountRequest);
    }

    @Operation(summary = "Does email and passowrd exist",
            description = "Checks if account with given email and password exists")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Account exists")
    })
    @GetMapping(path = "{email}/{password}")
    public boolean doesEmailAndPasswordExist(@Parameter(description = "E-mail of account to be checked") @PathVariable("email") String email,
                                             @Parameter(description = "Password of account to be checked") @PathVariable("password") String password) {
        return accountService.doesEmailAndPasswordExist(email, password);
    }


}
