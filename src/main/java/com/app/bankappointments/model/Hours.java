package com.app.bankappointments.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.DayOfWeek;


@Entity
@Table(name = "hours")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class Hours implements Serializable {

    @NotBlank
    @Id
    private DayOfWeek day;

    @NotBlank
    private int open_time;

    @NotBlank int close_time;


//----------------------------------------------------------------------------------------------
    // Getters and Setters Methods:

    public DayOfWeek getDayOfWeek() { return day; }

    public int getOpenTime() { return open_time;}



}