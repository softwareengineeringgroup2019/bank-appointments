package com.app.bankappointments.repository;

import com.app.bankappointments.model.Holidays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidaysRepository extends JpaRepository<Holidays, Long> {


}
