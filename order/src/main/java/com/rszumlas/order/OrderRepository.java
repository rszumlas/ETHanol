package com.rszumlas.order;

import com.rszumlas.clients.order.OrderRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

    @Query(value = "SELECT o FROM order o WHERE o.id = :id")
    OrderRequest findOrderById(@Param("id") Long id);

}
