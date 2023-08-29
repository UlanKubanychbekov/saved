package peaksoft.exception;

/**
 * author: Ulansky
 */
public class NotFoundException extends RuntimeException{
    public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message);
    }
}
