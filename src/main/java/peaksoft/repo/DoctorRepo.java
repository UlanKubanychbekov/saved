package peaksoft.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.dto.response.DoctorResponse;
import peaksoft.entity.Doctor;

import java.util.Optional;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor,Long> {
    Doctor findByEmail(String email);

    Optional<DoctorResponse> findDoctorById(Long aLong);
}
