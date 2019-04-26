package com.app.bankappointments.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "hours")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class Hours implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private Date date;

    @NotBlank
    private DayOfWeek day;


//----------------------------------------------------------------------------------------------
    // Getters and Setters Methods:

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public  void setDate(Date date) {
        this.date = date;
    }

    public DayOfWeek getDay() { return day; }

    public void setDay(DayOfWeek day) { this.day = day; }


}