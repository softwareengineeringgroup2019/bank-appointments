package com.app.bankappointments.Controller;

import com.app.bankappointments.repository.AppointmentsRepository;
import com.app.bankappointments.model.Appointments;
import com.app.bankappointments.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AppointmentsController {

    @Autowired
    AppointmentsRepository appointmentsRepository;

    // Get All appointments
    @GetMapping("/appointments")
    public List<Appointments> getAllAppointments() {
        return appointmentsRepository.findAll();
    }

}


