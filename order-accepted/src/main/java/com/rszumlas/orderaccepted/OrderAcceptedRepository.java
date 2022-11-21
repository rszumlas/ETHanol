package com.rszumlas.orderaccepted;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderAcceptedRepository extends CrudRepository<OrderAccepted, OrderAcceptedId> {
}
