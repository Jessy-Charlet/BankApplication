package BankApplication.ms_accounts.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Loan {

    private int loanNumber;

    private int customerId;

    private LocalDate startDt;

    private String loanType;

    private int totalLoan;

    private int amountPaid;

    private int outstandingAmount;

    private LocalDate createdDt;

    public Loan(int loanNumber, int customerId, LocalDate startDt, String loanType, int totalLoan, int amountPaid, int outstandingAmount, LocalDate createdDt) {
        this.loanNumber = loanNumber;
        this.customerId = customerId;
        this.startDt = startDt;
        this.loanType = loanType;
        this.totalLoan = totalLoan;
        this.amountPaid = amountPaid;
        this.outstandingAmount = outstandingAmount;
        this.createdDt = createdDt;
    }

    public Loan() {
    }
}