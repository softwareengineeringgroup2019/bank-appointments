package com.app.bankappointments.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;


@Entity
@Table(name = "appointments")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class Appointments implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private Time time;

    @NotBlank
    private Date date;

    @NotBlank
    private int day_of_week;

    //-----------------------------------------------------------------
    //getter/setter methods

    public Long getId() {return this.id;}

    public void setId(Long id) {this.id = id;}

    public Date getDate() {return date;}

    public void setDate(Date date) {this.date = date;}

    public int getDayOfWeek() {return day_of_week;}

    public void setDayOfWeek(int day_of_week) {this.day_of_week = day_of_week;
    }

    private Time getTime() {return this.time;}

    private void setTime(Time time) {this.time = time;}
}
