package com.example.myspringboot.repository;

import com.example.myspringboot.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    Participant findByUsername(String username);
}

