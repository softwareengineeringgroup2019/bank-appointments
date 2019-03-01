package com.app.bankappointments.repository;

import com.app.bankappointments.model.Hours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HoursRepository extends JpaRepository<Hours, Long> {

}