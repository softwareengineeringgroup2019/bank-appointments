package com.app.bankappointments.repository;

import com.app.bankappointments.model.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ServicesRepository extends JpaRepository<Services, Long> {

}
