package com.app.bankappointments.Controller;

import com.app.bankappointments.model.Locations;
import com.app.bankappointments.model.Services;
import com.app.bankappointments.model.Branch;
import com.app.bankappointments.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api")
public class BranchController {

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    public BranchController(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    @GetMapping("/branches")
    @CrossOrigin(origins = "http://localhost:3000")
    @ResponseBody
    public List<Branch> getBranch(
            @RequestParam String mortgage, String studentLoans, String checking, String savings, String autoLoan,
            String studentBanking, String creditCard, String investmentAccount, String homeEquity) {

        Boolean selectedMortgage = Boolean.parseBoolean(mortgage);
        Boolean selectedStudentLoans = Boolean.parseBoolean(studentLoans);
        Boolean selectedChecking = Boolean.parseBoolean(checking);
        Boolean selectedSavings = Boolean.parseBoolean(savings);
        Boolean selectedAutoLoan = Boolean.parseBoolean(autoLoan);
        Boolean selectedStudentBanking = Boolean.parseBoolean(studentBanking);
        Boolean selectedCreditCard = Boolean.parseBoolean(creditCard);
        Boolean selectedInvestmentAccount = Boolean.parseBoolean(investmentAccount);
        Boolean selectedHomeEquity = Boolean.parseBoolean(homeEquity);

        return branchRepository.findAll().parallelStream().filter(s -> s.hasMortgage(selectedMortgage) &&
                s.hasStudentLoans(selectedStudentLoans) && s.hasChecking(selectedChecking) &&
                s.hasSavings(selectedSavings) && s.hasAutoLoan(selectedAutoLoan) &&
                s.hasStudentBanking(selectedStudentBanking) && s.hasCreditCard(selectedCreditCard) &&
                s.hasInvestmentAccount(selectedInvestmentAccount) && s.hasHomeEquity(selectedHomeEquity))
                .collect(Collectors.toList());
    }
}