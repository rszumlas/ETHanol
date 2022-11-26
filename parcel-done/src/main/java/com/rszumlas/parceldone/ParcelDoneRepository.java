package com.rszumlas.parceldone;

import com.rszumlas.clients.parceldone.ParcelDoneRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ParcelDoneRepository extends CrudRepository<ParcelDone, Long> {

    @Query(value = "SELECT p FROM ParcelDone p WHERE p.account = :account")
    Optional<ParcelDoneRequest> findParcelDoneByAccountId(@Param("account") Long account_id);


}
