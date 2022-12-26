package com.rszumlas.shelf;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ShelfRepository extends CrudRepository<Shelf, Long> {

    @Query(value = "SELECT s FROM Shelf s WHERE s.vodka.id = :vodka_id")
    Shelf findShelfByVodkaId(@Param("vodka_id") Long vodka_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Shelf s SET s.crates = s.crates + :crates WHERE s.vodka.id = :vodka_id")
    void increaseCratesAmount(@Param("crates") Integer crates,
                              @Param("vodka_id") Long vodka_id);
    @Modifying
    @Transactional
    @Query(value = "UPDATE Shelf s SET s.crates = s.crates - :crates WHERE s.vodka.id = :vodka_id")
    void decreaseCratesAmount(@Param("crates") Integer crates,
                              @Param("vodka_id") Long vodka_id);

}
