package com.rszumlas.clients.account;

import com.rszumlas.clients.parcel.ParcelRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        contextId = "accountContextId",
        name = "account",
        url = "${clients.account.url}"
)
public interface AccountClient {

    @PatchMapping(path = "api/v1/account/{account_id}")
    void updateEthTotal(@PathVariable("account_id") Long account_id);

}
