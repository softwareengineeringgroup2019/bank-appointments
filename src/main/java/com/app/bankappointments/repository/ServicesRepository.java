package com.app.bankappointments.repository;

import com.app.bankappointments.model.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ServicesRepository extends JpaRepository<Services, Long> {

//    @Query("SELECT id FROM services WHERE checking = ?1 AND savings = ?2 AND credit_card = ?3 AND auto_loan = ?4 AND " +
//            "home_equity = ?5 AND investment_account = ?6 AND mortgage = ?7 AND student_banking = ?8 AND " +
//            "student_loans = ?9")
//    Optional<Services>findBankIdWithServices(boolean checking, boolean savings, boolean credit_card,
//                                                    boolean auto_loan, boolean home_equity, boolean investment_account,
//                                                    boolean mortgage, boolean student_banking, boolean student_loans);


}
