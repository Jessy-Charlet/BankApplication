package BankApplication.ms_accounts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerEmailException.class)
    public ResponseEntity<ResponseMessage> handleCustomerEmailException(CustomerEmailException ex) {
        ResponseMessage responseMessage = new ResponseMessage(ex.getMessage(), HttpStatus.CONFLICT.value());

        return new ResponseEntity<>(responseMessage, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseMessage> handleException(Exception ex) {
        ResponseMessage responseMessage = new ResponseMessage(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(responseMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
