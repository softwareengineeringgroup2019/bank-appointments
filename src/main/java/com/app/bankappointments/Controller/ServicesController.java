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
import java.lang.invoke.SerializedLambda;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Boolean.TRUE;
import static java.lang.Boolean.parseBoolean;
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

//    @GetMapping("/services")
//    @CrossOrigin(origins = "http://localhost:3000")
//    @ResponseBody
//    public List<Locations> getServices(
//            @RequestParam String mortgage, String studentLoans, String checking, String savings, String autoLoan,
//            String studentBanking, String creditCard, String investmentAccount, String homeEquity) {

//        Boolean selectedMortgage = Boolean.parseBoolean(mortgage);
//        Boolean selectedStudentLoans = Boolean.parseBoolean(studentLoans);
//        Boolean selectedChecking = Boolean.parseBoolean(checking);
//        Boolean selectedSavings = Boolean.parseBoolean(savings);
//        Boolean selectedAutoLoan = Boolean.parseBoolean(autoLoan);
//        Boolean selectedStudentBanking = Boolean.parseBoolean(studentBanking);
//        Boolean selectedCreditCard = Boolean.parseBoolean(creditCard);
//        Boolean selectedInvestmentAccount = Boolean.parseBoolean(investmentAccount);
//        Boolean selectedHomeEquity = Boolean.parseBoolean(homeEquity);
//
////        System.out.println("mortgage: " + mortgage);
////        System.out.println("studentLoans: " + studentLoans);
////        System.out.println("checking: " + checking);
////        System.out.println("savings: " + savings);
////        System.out.println("autoLoan: " + autoLoan);
////        System.out.println("studentBanking: " + studentBanking);
////        System.out.println("creditCard: " + creditCard);
////        System.out.println("investmentAccount: " + investmentAccount);
////        System.out.println("homeEquity: " + homeEquity);
//
//        List<Services> selectedServices = servicesRepository.findAll().parallelStream().filter(s -> s.hasMortgage(selectedMortgage) &&
//                s.hasStudentLoans(selectedStudentLoans) && s.hasChecking(selectedChecking) &&
//                s.hasSavings(selectedSavings) && s.hasAutoLoan(selectedAutoLoan) &&
//                s.hasStudentBanking(selectedStudentBanking) && s.hasCreditCard(selectedCreditCard) &&
//                s.hasInvestmentAccount(selectedInvestmentAccount) && s.hasHomeEquity(selectedHomeEquity))
//                .collect(Collectors.toList());
//
//        List<Locations> availableLocations = locationsRepository.findAll().parallelStream()
//                .filter(l -> l.getId() == selectedServices.parallelStream().findAny().get().getId()).collect(Collectors.toList());
//
//
//
//        return availableLocations;


        //WORKING FUNCTION
//        return servicesRepository.findAll().parallelStream().filter(s -> s.hasMortgage(selectedMortgage) &&
//                s.hasStudentLoans(selectedStudentLoans) && s.hasChecking(selectedChecking) &&
//                s.hasSavings(selectedSavings) && s.hasAutoLoan(selectedAutoLoan) &&
//                s.hasStudentBanking(selectedStudentBanking) && s.hasCreditCard(selectedCreditCard) &&
//                s.hasInvestmentAccount(selectedInvestmentAccount) && s.hasHomeEquity(selectedHomeEquity))
//                .collect(Collectors.toList());

//                .filter(s -> s.getMortgage().equals(Boolean.parseBoolean(mortgage))
//                        && s.getStudentLoans().equals(Boolean.parseBoolean(studentLoans)))
//                .collect(Collectors.toList());
//    }



//
//        // Get All Locations
//    @GetMapping("/services")
//    @CrossOrigin(origins = "http://localhost:3000")
//    public List<Services> getAllServices() {
//        return servicesRepository.findAll();
//    }

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