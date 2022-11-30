package com.rszumlas.parcelhandlinginfo;

import com.rszumlas.clients.parcelhandlinginfo.ParcelHandlingInfoRequest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ParcelHandlingInfoRepository extends CrudRepository<ParcelHandlingInfo, ParcelHandlingInfoId> {

    @Modifying
    @Transactional
    @Query(value = "" +
            "INSERT INTO parcel_handling_info " +
            "(parcel_id, shelf_id, created_at) " +
            "VALUES (:#{#phi.parcel_id}, :#{#phi.shelf_id}, :#{#phi.created_at})",
            nativeQuery = true
    )
    void insertParcelHandlingInfo(@Param("phi") ParcelHandlingInfoRequest phi);

}
