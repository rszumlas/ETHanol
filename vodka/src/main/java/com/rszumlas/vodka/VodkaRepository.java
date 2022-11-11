package com.rszumlas.vodka;

import com.rszumlas.clients.ordertype.OrderTypeRequest;
import com.rszumlas.clients.vodka.VodkaRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VodkaRepository extends JpaRepository<Vodka, Long> {

    @Query(value = "SELECT v FROM vodka v WHERE v.id = :id")
    VodkaRequest findById(@Param("id") Integer id);

}
