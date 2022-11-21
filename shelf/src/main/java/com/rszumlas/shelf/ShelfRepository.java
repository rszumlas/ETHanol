package com.rszumlas.shelf;

import com.rszumlas.clients.shelf.ShelfRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShelfRepository extends CrudRepository<Shelf, Long> {

    @Query(value = "SELECT o FROM shelf s WHERE s.vodka_id = :vodka_id")
    Optional<ShelfRequest> findByVodkaId(@Param("vodka_id") Integer vodka_id);

    @Modifying
    @Query(value = "UPDATE shelf s SET s.crates = :crates + s.crates WHERE s.vodka_id = :vodka_id")
    void updateCratesAmount(@Param("crates") Integer crates,
                            @Param("vodka_id") Long vodka_id);

}
