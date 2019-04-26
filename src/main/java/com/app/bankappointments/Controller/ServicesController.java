package com.app.bankappointments.Controller;

import com.app.bankappointments.model.Locations;
import com.app.bankappointments.repository.LocationRepository;
import com.app.bankappointments.repository.ServicesRepository;
import com.app.bankappointments.model.Services;
import com.app.bankappointments.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.xml.stream.Location;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Boolean.TRUE;
import static java.lang.Math.E;


@RestController
@RequestMapping("/api")
public class ServicesController {

    @Autowired
    private ServicesRepository servicesRepository;

    @Autowired
    private LocationRepository locationsRepository;

    @Autowired
    public ServicesController(ServicesRepository servicesRepository) {
        this.servicesRepository = servicesRepository;
    }

    // Get All Locations
    @GetMapping("/services")
    public List<Services> getAllServices(Boolean checking) {
        return servicesRepository.findAll()
                .parallelStream().filter(s -> s.getChecking() == true && s.getAutoLoan() == true &&
                        s.getInvestmentAccount() == true && s.getHomeEquity() == true && s.getStudentLoans() == true &&
                        s.getSavings() == true && s.getCreditCard() == true && s.getMortgage() == true &&
                        s.getStudentBanking() == true).collect(Collectors.toList());
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

    // Delete a Locations
    @DeleteMapping("/services/{id}")
    public ResponseEntity<?> deleteServices(@PathVariable(value="id") Long servicesId) {
        Services services = servicesRepository.findById(servicesId)
                .orElseThrow(() -> new ResourceNotFoundException("Services", "id", servicesId));

        servicesRepository.delete(services);

        return  ResponseEntity.ok().build();

    }
}