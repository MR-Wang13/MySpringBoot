package com.example.myspringboot.controller;
import com.example.myspringboot.entity.Clinician;
import com.example.myspringboot.service.ClinicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clinicians")
public class ClinicianController {

    @Autowired
    private ClinicianService clinicianService;

    @PostMapping
    public ResponseEntity<Clinician> createClinician(@RequestBody Clinician clinician) {
        return ResponseEntity.ok(clinicianService.saveClinician(clinician));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clinician> getClinicianById(@PathVariable Long id) {
        Clinician clinician = clinicianService.getClinicianById(id);
        if (clinician != null) {
            return ResponseEntity.ok(clinician);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Clinician> updateClinician(@PathVariable Long id, @RequestBody Clinician clinicianDetails) {
        Clinician clinician = clinicianService.getClinicianById(id);
        if (clinician != null) {
            clinician.setUsername(clinicianDetails.getUsername());
            clinician.setPassword(clinicianDetails.getPassword()); // 注意：在实际应用中，密码应进行加密处理
            return ResponseEntity.ok(clinicianService.updateClinician(clinician));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClinician(@PathVariable Long id) {
        clinicianService.deleteClinician(id);
        return ResponseEntity.ok().build();
    }
}
