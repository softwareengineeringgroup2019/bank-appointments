package com.app.bankappointments.Controller;

import com.app.bankappointments.repository.HoursRepository;
import com.app.bankappointments.model.Hours;
import com.app.bankappointments.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api")
public class HoursController {

    @Autowired
    HoursRepository hoursRepository;

    // Get All Hours
    @GetMapping("/hours")
    public List<Hours> getAllHours() {
        return hoursRepository.findAll();
    }

    // Create a new Hours
    @PostMapping("/hours")
    public Hours createHours(@Valid @RequestBody Hours hours) {
        return hoursRepository.save(hours);
    }

    // Get a Single Hours
    @GetMapping("/hours/{id}")
    public Hours getHoursById(@PathVariable(value="id") Long hoursId) {
        return hoursRepository.findById(hoursId)
                .orElseThrow(() -> new ResourceNotFoundException("Hours", "id", hoursId));
    }

    // Update a Hours
    @PutMapping("/hours/{id}")
    public Hours updateHours(@PathVariable(value="id") Long hoursId,
                                   @Valid @RequestBody Hours hoursDetails) {
        Hours hours = hoursRepository.findById(hoursId)
                .orElseThrow(() -> new ResourceNotFoundException("Hours", "id", hoursId));

        //Setter methods will be called here
        hours.setDate(hoursDetails.getDate());
        hours.setDay(hoursDetails.getDay());

        Hours updateHours = hoursRepository.save(hours);
        return updateHours;
    }
//
//    // Delete a Hours
    @DeleteMapping("/hours/{id}")
    public ResponseEntity<?> deleteHours(@PathVariable(value="id") Long hoursId) {
        Hours hours = hoursRepository.findById(hoursId)
                .orElseThrow(() -> new ResourceNotFoundException("Hours", "id", hoursId));

        hoursRepository.delete(hours);

        return  ResponseEntity.ok().build();

    }
}