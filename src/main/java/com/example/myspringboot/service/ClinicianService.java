package com.example.myspringboot.service;
import com.example.myspringboot.entity.Clinician;
import com.example.myspringboot.repository.ClinicianRepository;
import com.example.myspringboot.vo.CheckUserVo;
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
    public CheckUserVo validateClinicianLogin(String username, String password) {
        CheckUserVo vo = new CheckUserVo(true,"");
        Clinician clinician = clinicianRepository.findByUsername(username);
        if (clinician == null) {
            vo.setChecked(false);
            vo.setResErrMsg("User does not exist");
        }else if(!clinician.getPassword().equals(password)){
            vo.setChecked(false);
            vo.setResErrMsg("Incorrect password");
        }
        return vo;
    }
}
