package BankApplication.ms_accounts.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CustomerAllDTO {
    private Customer customer;
    private List<Card> cards;
    private List<Loan> loans;

    public CustomerAllDTO(Customer customer, List<Card> cards, List<Loan> loans) {
        this.customer = customer;
        this.cards = cards;
        this.loans = loans;
    }

    public CustomerAllDTO() {}
}
