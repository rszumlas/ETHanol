package com.rszumlas.parcel;

import com.rszumlas.clients.parcel.ParcelRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ParcelRepository extends CrudRepository<Parcel, Long> {

    @Query(value = "SELECT p FROM Parcel p WHERE p.id = :id")
    ParcelRequest findParcelById(@Param("id") Long id);

}
