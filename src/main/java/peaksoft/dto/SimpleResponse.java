package peaksoft.dto;

import lombok.Builder;
import org.springframework.http.HttpStatus;

/**
 * author: Ulansky
 */
@Builder
public record SimpleResponse(HttpStatus httpStatus, String message) {
}
