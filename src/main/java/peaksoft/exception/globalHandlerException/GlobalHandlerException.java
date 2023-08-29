package peaksoft.exception.globalHandlerException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import peaksoft.exception.ExceptionResponse;
import peaksoft.exception.InvalidEmailException;
import peaksoft.exception.NotFoundException;

/**
 * author: Ulansky
 */
@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(InvalidEmailException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse invalidEmailException(InvalidEmailException i) {
        return new ExceptionResponse(HttpStatus.BAD_REQUEST, i.getClass().getSimpleName(), i.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.FOUND)
    public ExceptionResponse notFound(NotFoundException n) {
        return new ExceptionResponse(HttpStatus.FOUND, n.getClass().getSimpleName(), n.getMessage());
    }
}
