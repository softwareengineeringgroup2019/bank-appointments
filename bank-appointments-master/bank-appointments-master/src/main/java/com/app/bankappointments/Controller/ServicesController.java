package com.app.bankappointments.Controller;

import com.app.bankappointments.repository.ServicesRepository;
import com.app.bankappointments.model.Services;
import com.app.bankappointments.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api")
public class ServicesController {

    @Autowired
    ServicesRepository servicesRepository;

    // Get All Locations
    @GetMapping("/services")
    public List<Services> getAllLocations() {
        return servicesRepository.findAll();
    }

    // Create a new Service
    @PostMapping("/services")
    public Services createServices(@Valid @RequestBody Services services) {
        return servicesRepository.save(services);
    }

    // Get a Single Service
    @GetMapping("/services/{id}")
    public Services getServicesById(@PathVariable(value="id") Long servicesId) {
        return servicesRepository.findById(servicesId)
                .orElseThrow(() -> new ResourceNotFoundException("Services", "id", servicesId));
    }

    // Update a Service
    @PutMapping("/services/{id}")
    public Services updateServices(@PathVariable(value="id") Long servicesId,
                                   @Valid @RequestBody Services servicesDetails) {
        Services services = servicesRepository.findById(servicesId)
                .orElseThrow(() -> new ResourceNotFoundException("Services", "id", servicesId));

        services.setChecking(servicesDetails.getChecking());
        services.setSavings(servicesDetails.getSavings());
        services.setStudentBanking(servicesDetails.getStudentBanking());
        services.setAutoLoan(servicesDetails.getAutoLoan());
        services.setHomeEquity(servicesDetails.getHomeEquity());
        services.setMortgage(services.getMortgage());
        services.setStudentLoans(servicesDetails.getStudentLoans());
        services.setCreditCard(servicesDetails.getCreditCard());
        services.setInvestmentAccount(servicesDetails.getInvestmentAccount());


        Services updateServices = servicesRepository.save(services);
        return updateServices;
    }

    // Delete a Location
    @DeleteMapping("/services/{id}")
    public ResponseEntity<?> deleteServices(@PathVariable(value="id") Long servicesId) {
        Services services = servicesRepository.findById(servicesId)
                .orElseThrow(() -> new ResourceNotFoundException("Services", "id", servicesId));

        servicesRepository.delete(services);

        return  ResponseEntity.ok().build();

    }
}