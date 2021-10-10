package by.training.task07.dao.exception;

public class DaoException extends Exception{
    public DaoException() {
    }
    public DaoException(String message) {
        super(message);
    }
    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }
    public DaoException(Throwable cause) {
        super(cause);
    }
}
