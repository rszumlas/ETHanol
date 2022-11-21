package com.rszumlas.vodka;

import com.rszumlas.clients.vodka.VodkaRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VodkaRepository extends CrudRepository<Vodka, Long> {

    @Query(value = "SELECT v FROM Vodka v WHERE v.id = :id")
    VodkaRequest findVodkaById(@Param("id") Long id);

}
