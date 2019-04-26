package com.app.bankappointments.repository;

import com.app.bankappointments.model.Locations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LocationRepository extends JpaRepository<Locations, Long> {

    @Query(value = "SELECT * FROM locations WHERE city = ?1", nativeQuery = true)
    List<Object> findByCity(String city);

}

