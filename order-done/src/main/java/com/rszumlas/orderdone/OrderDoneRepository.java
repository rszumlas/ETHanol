package com.rszumlas.orderdone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Time;

@Repository
public interface OrderDoneRepository extends CrudRepository<OrderDone, Long> {

    @Modifying
    @Query(value = "INSERT INTO order_done o (o.order_id, o.employee_id, o.delivery_time, o.eth_earned) VALUES (:order_id, :employee_id, :delivery_time, :eth_earned)")
    void insertOrderDone(@Param("order_id") Long order_id,
                         @Param("employee_id") Long employee_id,
                         @Param("delivery_time") Time delivery_time,
                         @Param("eth_earned") Double eth_earned);

}
