package BankApplication.ms_loans.service;

import BankApplication.ms_loans.model.CustomerIdDTO;
import BankApplication.ms_loans.model.Loan;
import BankApplication.ms_loans.model.LoanFormDTO;
import BankApplication.ms_loans.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class LoanService {
    private final LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public List<Loan> findLoanByCustomerId(CustomerIdDTO customerId){
        if(loanRepository.existsLoansByCustomerId(customerId.getCustomerId())){
            return loanRepository.findLoanByCustomerId(customerId.getCustomerId()).get();
        }
        throw new RuntimeException();
    }
    public Loan saveLoan(LoanFormDTO request) {
        Loan loan = new Loan();
        loan.setLoanType(request.getLoanType());
        loan.setTotalLoan(request.getTotalLoan());
        loan.setAmountPaid(request.getAmountPaid());
        loan.setCustomerId(request.getCustomerId());
        loan.setOutstandingAmount(request.getTotalLoan());
        loan.setStartDt(LocalDate.now().plusDays(30));
        loan.setCreatedDt(LocalDate.now());
        return loanRepository.save(loan);
    }
}
