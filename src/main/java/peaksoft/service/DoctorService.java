package peaksoft.service;

import peaksoft.dto.SimpleResponse;
import peaksoft.dto.request.DoctorRequest;
import peaksoft.dto.response.DoctorResponse;

/**
 * author: Ulansky
 */
public interface DoctorService {
    SimpleResponse saveDoctor(DoctorRequest doctorRequest);

    DoctorResponse getById(Long id);

    SimpleResponse update(Long id, DoctorRequest doctorRequest);
}
