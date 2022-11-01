package com.rszumlas.orderhandlinginfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderHandlingInfoRepository extends JpaRepository<OrderHandlingInfo, OrderHandlingInfoId> {
}
