package com.example.myspringboot.service;
import com.example.myspringboot.entity.Clinician;
import com.example.myspringboot.repository.ClinicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClinicianService {

    @Autowired
    private ClinicianRepository clinicianRepository;

    public Clinician saveClinician(Clinician clinician) {
        return clinicianRepository.save(clinician);
    }

    public Clinician getClinicianById(Long id) {
        return clinicianRepository.findById(id).orElse(null);
    }

    public Clinician updateClinician(Clinician clinician) {
        return clinicianRepository.save(clinician);
    }

    public void deleteClinician(Long id) {
        clinicianRepository.deleteById(id);
    }
}
