package com.rszumlas.orderdone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDoneRepository extends JpaRepository<OrderDone, Long> {



}
