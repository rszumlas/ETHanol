package com.rszumlas.parceldone;

import com.rszumlas.clients.parceldone.ParcelDoneRequest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ParcelDoneRepository extends CrudRepository<ParcelDone, Long> {

    @Modifying
    @Transactional
    @Query(value = "" +
            "INSERT INTO parcel_done " +
            "(parcel_id, account_id, delivery_time_seconds, is_finished) " +
            "VALUES (:#{#pd.parcel_id}, :#{#pd.account_id}, :#{#pd.delivery_time_seconds}, :#{#pd.is_finished})",
            nativeQuery = true
    )
    void saveParcelDone(@Param("pd") ParcelDoneRequest pd);

    @Query(value = "" +
            "SELECT pd.is_finished " +
            "FROM ParcelDone pd " +
            "WHERE pd.id = :id")
    Boolean checkIfFinished(@Param("id") Long id);

}
