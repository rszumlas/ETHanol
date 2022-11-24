package com.rszumlas.shelf;

import com.rszumlas.clients.shelf.ShelfRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface ShelfRepository extends CrudRepository<Shelf, Long> {

    @Query(value = "SELECT s FROM Shelf s WHERE s.vodka = :vodka")
    Optional<ShelfRequest> findShelfByVodkaId(@Param("vodka") Long vodka_id);

    @Modifying
    @Query(value = "UPDATE Shelf s SET s.crates = :crates + s.crates WHERE s.vodka = :vodka")
    void updateCratesAmount(@Param("crates") Integer crates,
                            @Param("vodka") Long vodka_id);

}
