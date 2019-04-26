package com.app.bankappointments.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "services")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class Services implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private Boolean checking;

    @NotBlank
    private Boolean savings;

    @NotBlank
    private Boolean student_banking;

    @NotBlank
    private Boolean auto_loan;

    @NotBlank
    private Boolean home_equity;

    @NotBlank
    private Boolean mortgage;

    @NotBlank
    private Boolean student_loans;

    @NotBlank
    private Boolean credit_card;

    @NotBlank
    private Boolean investment_account;


    //    ----------------------------------------------------------------------------------------------
    // Getters and Setters Methods:

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getChecking() {
        return checking;
    }

    public void setChecking(Boolean offered) {
        this.checking = offered;
    }

    public Boolean getSavings() {
        return savings;
    }

    public void setSavings(Boolean offered) {
        this.savings = offered;
    }

    public Boolean getStudentBanking() {
        return student_banking;
    }

    public void setStudentBanking(Boolean offered) {
        this.student_banking = offered;
    }

    public Boolean getAutoLoan() {
        return auto_loan;
    }

    public void setAutoLoan(Boolean offered) {
        this.auto_loan = offered;
    }

    public Boolean getHomeEquity() {
        return home_equity;
    }

    public void setHomeEquity(Boolean offered) {
        this.home_equity = offered;
    }

    public Boolean getMortgage() {
        return mortgage;
    }

    public void setMortgage(Boolean offered) {
        this.mortgage = offered;
    }

    public Boolean getStudentLoans() {
        return student_loans;
    }

    public void setStudentLoans(Boolean offered) {
        this.student_loans = offered;
    }

    public Boolean getCreditCard() {
        return credit_card;
    }

    public void setCreditCard(Boolean offered) {
        this.credit_card = offered;
    }
    public Boolean getInvestmentAccount() {
        return investment_account;
    }

    public void setInvestmentAccount(Boolean offered) {
        this.investment_account = offered;
    }
}



