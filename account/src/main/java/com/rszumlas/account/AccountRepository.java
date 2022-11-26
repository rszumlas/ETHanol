package com.rszumlas.account;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AccountRepository extends CrudRepository<Account, Long> {

    @Modifying
    @Query(value = "UPDATE Account a SET a.eth_total = a.eth_total + :eth_earned WHERE a.id = :id")
    void updateEthTotal(@Param("id") Long account_id,
                        @Param("eth_earned") Double eth_earned);

}
