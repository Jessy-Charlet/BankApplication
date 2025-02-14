package BankApplication.ms_loans.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerIdDTO {

    private int customerId;

    public CustomerIdDTO(int customerId) {
        this.customerId = customerId;
    }
}
