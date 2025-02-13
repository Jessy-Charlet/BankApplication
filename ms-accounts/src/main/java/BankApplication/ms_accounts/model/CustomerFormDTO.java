package BankApplication.ms_accounts.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CustomerFormDTO {

    private String name;
    private String email;
    private String mobileNumber;

    public CustomerFormDTO(String mobileNumber, String email, String name) {
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.name = name;
    }
}
