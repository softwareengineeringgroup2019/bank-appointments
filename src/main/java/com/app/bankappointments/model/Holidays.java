package com.app.bankappointments.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "holidays")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class Holidays implements Serializable {

    @NotBlank
    @Id
    private Date holiday;

    //------------------------------------------------------------------------------
    //getter/setter methods

    public Date getHoliday() {
        return holiday;
    }
}

