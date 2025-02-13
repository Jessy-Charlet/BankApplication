package BankApplication.ms_accounts.exception;



public class CustomerEmailException extends RuntimeException {
    public CustomerEmailException(String message) {
        super(message);
    }
    public CustomerEmailException(String message, Object... args) {
        super(String.format(message, args));
    }
}
