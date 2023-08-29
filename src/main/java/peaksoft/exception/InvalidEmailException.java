package peaksoft.exception;

/**
 * author: Ulansky
 */
public class InvalidEmailException extends NullPointerException {
    public InvalidEmailException() {
    }

    public InvalidEmailException(String s) {
        super(s);
    }
}
