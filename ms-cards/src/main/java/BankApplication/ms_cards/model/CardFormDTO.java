package BankApplication.ms_cards.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
public class CardFormDTO {

    private int customerId;

    private String cardNumber;

    private String cardType;

    private int totalLimit;

}