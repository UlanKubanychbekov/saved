package peaksoft.service.servieImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import peaksoft.dto.SimpleResponse;
import peaksoft.dto.request.DoctorRequest;
import peaksoft.dto.response.DoctorResponse;
import peaksoft.entity.Doctor;
import peaksoft.exception.InvalidEmailException;
import peaksoft.exception.NotFoundException;
import peaksoft.repo.DoctorRepo;
import peaksoft.service.DoctorService;

/**
 * author: Ulansky
 */
@Service
@RequiredArgsConstructor
@Transactional
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepo doctorRepo;

    @Override
    public SimpleResponse saveDoctor(DoctorRequest doctorRequest) {
        Doctor existDoctor = doctorRepo.findByEmail(doctorRequest.email());
        if (existDoctor == null) {
            Doctor doctor = new Doctor();
            doctor.setName(doctorRequest.name());
            doctor.setEmail(doctorRequest.email());
            doctorRepo.save(doctor);
            return SimpleResponse.builder()
                    .httpStatus(HttpStatus.OK)
                    .message("successfully saved").build();
        } else if (existDoctor != null) {
            throw new InvalidEmailException(String.format("такой email: %s уже существует", doctorRequest.email()));
        }
        return null;
    }

    @Override
    public DoctorResponse getById(Long id) {
        return doctorRepo.findDoctorById(id).orElseThrow(()-> new NotFoundException("doctor with id: " + id + " не существует"));
    }

    @Override
    public SimpleResponse update(Long id, DoctorRequest doctorRequest) {
        Doctor updateDoctor = doctorRepo.findById(id).orElseThrow(()->new NotFoundException("not found exception"));
        updateDoctor.setName(doctorRequest.name());
        updateDoctor.setEmail(doctorRequest.email());
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("succes update").build();
    }
}
