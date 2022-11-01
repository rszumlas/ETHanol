package com.rszumlas.orderaccepted;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderAcceptedRepository extends JpaRepository<OrderAccepted, OrderAcceptedId> {
}
