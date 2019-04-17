package com.app.bankappointments.Controller;

import com.app.bankappointments.model.Holidays;
import com.app.bankappointments.repository.HolidaysRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.bankappointments.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api")
public class HolidaysController {

    @Autowired
    private HolidaysRepository holidaysRepository;

    // Get All Holidays
    @GetMapping("/holidays")
    public List<Holidays> getAllHolidays() {
        return holidaysRepository.findAll();
    }
}
