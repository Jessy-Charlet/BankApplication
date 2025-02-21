package BankApplication.ms_accounts.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
public class Card {

    private int cardId;

    private int customerId;

    private String cardNumber;

    private String cardType;

    private int totalLimit;

    private int amountUsed;

    private int availableAmount;

    private LocalDate createDt;

    public Card(int cardId, int customerId, String cardNumber, String cardType, int totalLimit, int amountUsed, int availableAmount, LocalDate createDt) {
        this.cardId = cardId;
        this.customerId = customerId;
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.totalLimit = totalLimit;
        this.amountUsed = amountUsed;
        this.availableAmount = availableAmount;
        this.createDt = createDt;
    }

    public Card() {
    }
}