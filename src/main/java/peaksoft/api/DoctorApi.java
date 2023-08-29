package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.SimpleResponse;
import peaksoft.dto.request.DoctorRequest;
import peaksoft.dto.response.DoctorResponse;
import peaksoft.service.DoctorService;

/**
 * author: Ulansky
 */
@RestController
@RequestMapping("/api/doctor")
@RequiredArgsConstructor
public class DoctorApi {
    private final DoctorService doctorService;

    @PostMapping
    public SimpleResponse saveDoctor(@RequestBody DoctorRequest doctorRequest) {
        return doctorService.saveDoctor(doctorRequest);
    }
    @GetMapping("/{id}")
    public DoctorResponse getById(@PathVariable Long id){
        return doctorService.getById(id);
    }
    @PutMapping("/{id}")
    public SimpleResponse update(@PathVariable Long id,@RequestBody DoctorRequest doctorRequest){
        return doctorService.update(id,doctorRequest);
    }
}
