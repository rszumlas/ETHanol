package com.rszumlas.parcel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ParcelRepository extends JpaRepository<Parcel, Long> {

    @Query(value = "SELECT p FROM Parcel p WHERE p.id = :id")
    Parcel findParcelById(@Param("id") Long id);

}
