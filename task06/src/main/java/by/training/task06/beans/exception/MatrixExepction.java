package by.training.task06.beans.exception;

public class MatrixExepction extends Exception {
    public MatrixExepction() {
    }

    public MatrixExepction(String message) {
        super(message);
    }
    public MatrixExepction(String message, Throwable cause) {
        super(message, cause);
    }
    public MatrixExepction(Throwable cause) {
        super(cause);
    }
}
