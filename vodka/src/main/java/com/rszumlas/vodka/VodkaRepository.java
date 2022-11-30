package com.rszumlas.vodka;

import com.rszumlas.clients.vodka.VodkaRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface VodkaRepository extends CrudRepository<Vodka, Long> {

    @Query(value = "SELECT v FROM Vodka v WHERE v.id = :vodka_id")
    Vodka findVodkaById(@Param("vodka_id") Long vodka_id);

}
