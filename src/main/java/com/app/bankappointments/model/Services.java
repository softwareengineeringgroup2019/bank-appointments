package com.app.bankappointments.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@SqlResultSetMapping(
        name = "services",
        entities = @EntityResult(
                entityClass = Services.class,
                fields = {
                        @FieldResult(name = "id", column = "id"),
                        @FieldResult(name = "checking", column = "checking"),
                        @FieldResult(name = "savings", column = "savings"),
                        @FieldResult(name = "student_banking", column = "student_banking"),
                        @FieldResult(name = "auto_loan", column = "auto_loan"),
                        @FieldResult(name = "home_equity", column = "home_equity"),
                        @FieldResult(name = "mortgage", column = "mortgage"),
                        @FieldResult(name = "student_loans", column = "student_loans"),
                        @FieldResult(name = "credit_card", column = "credit_card"),
                        @FieldResult(name = "investment_account", column = "investment_account")}))



@Table(name = "services")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class Services implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //    @NotBlank
//    @Column(name = "auto_loan")
    private Boolean auto_loan;

    //    @NotBlank
//    @Column(name = "checking")
    private Boolean checking;

    //    @NotBlank
//    @Column(name = "credit_card")
    private Boolean credit_card;

    //    @NotBlank
//    @Column(name = "home_equity")
    private Boolean home_equity;

    //    @NotBlank
//    @Column(name = "investment_account")
    private Boolean investment_account;

    //    @NotBlank
//    @Column(name = "mortgage")
    private Boolean mortgage;

    //    @NotBlank
//    @Column(name = "savings")
    private Boolean savings;

    //    @NotBlank
//    @Column(name = "student_banking")
    private Boolean student_banking;

    //    @NotBlank
//    @Column(name = "student_loans")
    private Boolean student_loans;


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

    public boolean hasMortgage(Boolean mortgage) {
        return !mortgage || mortgage == this.mortgage;
    }




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



//    public boolean hasServices(Services services){
//        if(services.getChecking()){
//            if(!this.getChecking())
//                return false;
//        }
//        if(services.getChecking()){
//            if(!this.getChecking())
//                return false;
//        }
//        if(services.getChecking()){
//            if(!this.getChecking())
//                return false;
//        }
//        if(services.getChecking()){
//            if(!this.getChecking())
//                return false;
//        }
//        if(services.getChecking()){
//            if(!this.getChecking())
//                return false;
//        }
//        if(services.getChecking()){
//            if(!this.getChecking())
//                return false;
//        }
//        return true;
//    }

    }



