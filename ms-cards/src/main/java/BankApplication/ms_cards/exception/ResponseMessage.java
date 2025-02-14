package BankApplication.ms_cards.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseMessage {

    private String message;
    private int status;


    public ResponseMessage(String message, int status) {
        this.message = message;
        this.status = status;
    }
}
