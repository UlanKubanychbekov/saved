package peaksoft.dto.request;

import lombok.Builder;

/**
 * author: Ulansky
 */
@Builder
public record DoctorRequest (String name,String email){
}
