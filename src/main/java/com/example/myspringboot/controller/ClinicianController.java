package com.example.myspringboot.controller;
import com.example.myspringboot.entity.Clinician;
import com.example.myspringboot.service.ClinicianService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clinicians")
@Api(description = "APIs related to clinician ",tags = "ClinicianController")
public class ClinicianController {

    @Autowired
    private ClinicianService clinicianService;

    @ApiOperation(value = "createClinician" , notes = "createClinician")
    @PostMapping
    public ResponseEntity<Clinician> createClinician(@RequestBody Clinician clinician) {
        return ResponseEntity.ok(clinicianService.saveClinician(clinician));
    }

    @ApiOperation(value = "getClinicianById" , notes = "getClinicianById")
    @GetMapping("/{id}")
    public ResponseEntity<Clinician> getClinicianById(@PathVariable Long id) {
        Clinician clinician = clinicianService.getClinicianById(id);
        if (clinician != null) {
            return ResponseEntity.ok(clinician);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @ApiOperation(value = "updateClinician" , notes = "updateClinician")
    @PutMapping("/{id}")
    public ResponseEntity<Clinician> updateClinician(@PathVariable Long id, @RequestBody Clinician clinicianDetails) {
        Clinician clinician = clinicianService.getClinicianById(id);
        if (clinician != null) {
            clinician.setUsername(clinicianDetails.getUsername());
            clinician.setPassword(clinicianDetails.getPassword());
            return ResponseEntity.ok(clinicianService.updateClinician(clinician));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @ApiOperation(value = "deleteClinician" , notes = "deleteClinician")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClinician(@PathVariable Long id) {
        clinicianService.deleteClinician(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/validateLogin")
    public ResponseEntity<?> validateClinicianLogin(@RequestParam String username, @RequestParam String password) {
        boolean isValid = clinicianService.validateClinicianLogin(username, password);
        if (isValid) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
