package peaksoft.dto.response;

import lombok.Builder;

/**
 * author: Ulansky
 */
@Builder
public record DoctorResponse (String name,String email){
}
