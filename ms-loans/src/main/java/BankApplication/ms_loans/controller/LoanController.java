package BankApplication.ms_loans.controller;

import BankApplication.ms_loans.model.CustomerIdDTO;
import BankApplication.ms_loans.model.Loan;
import BankApplication.ms_loans.model.LoanFormDTO;
import BankApplication.ms_loans.service.LoanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/loan")
public class LoanController {
    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping("/me")
    public List<Loan> findMyLoan(@RequestBody CustomerIdDTO customerId) {
        return loanService.findLoanByCustomerId(customerId);
    }

    @PostMapping("/add")
    public ResponseEntity<Loan> addLoan(@RequestBody LoanFormDTO request) {
        Loan loan = loanService.saveLoan(request);
        if(loan == null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(loan, HttpStatus.CREATED);
    }
}
