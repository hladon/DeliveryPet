package com.repository;

import com.model.Cargo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CargoRepository extends CrudRepository<Cargo, Integer> {
    @Query(value = "Select distance from distance where departure=:from and destination=:to",nativeQuery = true)
    Integer findDistance(@Param("from") String departure,@Param("to") String destination);
}
