package com.app.bankappointments.repository;

import com.app.bankappointments.model.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ServicesRepository extends JpaRepository<Services, Long> {

    @Query(value = "SELECT * FROM SERVICES WHERE CHECKING = ?1", nativeQuery = true)
    Services findByChecking();
}
//    @Query(value = "select s.id from services s where s.checking = ?1 and s.savings = ?2 and s.credit_card = ?3 and s.auto_loan = ?4 and s.home_equity = ?5 and s.investment_account = ?6 and s.mortgage = ?7 and s.student_banking = ?8 and s.student_loans = ?9", nativeQuery = true)
//    List<Services> getAllServices(Boolean checking, Boolean savings, Boolean credit_card, Boolean auto_loan, Boolean home_equity, Boolean investment_account, Boolean mortgage, Boolean student_banking, Boolean student_loans);


