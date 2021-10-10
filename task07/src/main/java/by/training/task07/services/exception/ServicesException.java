package by.training.task07.services.exception;

public class ServicesException extends Exception {
    public ServicesException() {
    }

    public ServicesException(String message) {
        super(message);
    }
    public ServicesException(String message, Throwable cause) {
        super(message, cause);
    }
    public ServicesException(Throwable cause) {
        super(cause);
    }
}
