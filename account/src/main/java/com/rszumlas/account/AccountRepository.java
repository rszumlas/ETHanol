package com.rszumlas.account;

import com.rszumlas.clients.account.AccountRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    @Modifying
    @Transactional
    @Query(value = "" +
            "INSERT INTO account (email, password, eth_total) " +
            "VALUES (:#{#a.email}, :#{#a.password}, :#{#a.eth_total})",
            nativeQuery = true
    )
    void insertAccount(@Param("a") AccountRequest a);

    Optional<Account> findByEmail(String email);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "" +
            "UPDATE Account a " +
            "SET a.eth_total = a.eth_total + :eth_earned " +
            "WHERE a.id = :id"
    )
    void updateEthTotal(@Param("id") Long account_id,
                        @Param("eth_earned") Double eth_earned);

    @Query(value = "" +
            "SELECT EXISTS " +
            "(SELECT 1 FROM account WHERE email = :email)",
            nativeQuery = true
    )
    boolean isEmailTaken(@Param("email") String email);

    @Query(value = "" +
            "SELECT EXISTS " +
            "(SELECT 1 FROM account " +
            "WHERE email = :email AND password = :password)",
            nativeQuery = true)
    boolean doesEmailAndPasswordExist(@Param("email") String email,
                                      @Param("password") String password);

}
