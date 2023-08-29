package peaksoft.exception;

import lombok.Builder;
import org.springframework.http.HttpStatus;

/**
 * author: Ulansky
 */
@Builder
public record ExceptionResponse(HttpStatus httpStatus,String exceptionClassName,String message) {
}
