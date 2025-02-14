package BankApplication.ms_cards.exception;



public class CardNumberException extends RuntimeException {
    public CardNumberException(String message) {
        super(message);
    }
    public CardNumberException(String message, Object... args) {
        super(String.format(message, args));
    }
}
