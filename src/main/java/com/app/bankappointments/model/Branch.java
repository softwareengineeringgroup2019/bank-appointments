package com.app.bankappointments.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "branch")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class Branch implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String address;

    @NotBlank
    private String city;

    @NotBlank
    private String state;

    @NotBlank
    private String zip_code;

    @NotBlank
    private Boolean auto_loan;

    @NotBlank
    private Boolean checking;

    @NotBlank
    private Boolean credit_card;

    @NotBlank
    private Boolean home_equity;

    @NotBlank
    private Boolean investment_account;

    @NotBlank
    private Boolean mortgage;

    @NotBlank
    private Boolean savings;

    @NotBlank
    private Boolean student_banking;

    @NotBlank
    private Boolean student_loans;

    @NotBlank
    private String latitude;

    @NotBlank
    private String longitude;



    //    ----------------------------------------------------------------------------------------------
    // Getters and Setters Methods:

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zip_code;
    }

    public void setZipcode(String zip_code) {
        this.zip_code = zip_code;
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

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }


    public boolean hasMortgage(Boolean mortgage) {
        return !mortgage || mortgage == this.mortgage;
    }

    public boolean hasSavings(Boolean savings) {
        return !savings || savings == this.savings;
    }

    public boolean hasChecking(Boolean checking) {
        return !checking || checking == this.checking;
    }

    public boolean hasStudentBanking(Boolean student_banking) { return  !student_banking || student_banking == this.student_banking; }

    public boolean hasAutoLoan(Boolean auto_loan) {
        return !auto_loan || auto_loan == this.auto_loan;
    }

    public boolean hasCreditCard(boolean credit_card) {
        return !credit_card || credit_card == this.credit_card;
    }

    public boolean hasHomeEquity(boolean home_equity) {
        return !home_equity || home_equity == this.home_equity;
    }

    public boolean hasInvestmentAccount(boolean investment_account) { return !investment_account || investment_account == this.investment_account; }

    public boolean hasStudentLoans(Boolean student_loans) {
        if (student_loans) {
            if (student_loans == this.student_loans) {
                return true;
            }
            else {
                return false;
            }
        }
        return true;

    }





}



