package com.example.myspringboot.repository;
import com.example.myspringboot.entity.Clinician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicianRepository extends JpaRepository<Clinician, Long> {
    Clinician findByUsername(String username);
}
