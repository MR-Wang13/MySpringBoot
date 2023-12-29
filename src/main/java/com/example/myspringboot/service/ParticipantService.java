package com.example.myspringboot.service;
import com.example.myspringboot.entity.Participant;
import com.example.myspringboot.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantService {

    @Autowired
    private ParticipantRepository participantRepository;

    public Participant saveParticipant(Participant participant) {
        return participantRepository.save(participant);
    }

    public List<Participant> getAllParticipants() {
        return participantRepository.findAll();
    }

    public Participant getParticipantById(Long id) {
        return participantRepository.findById(id).orElse(null);
    }


    public List<Participant> getParticipantByIds(List<Long> ids) {
        return participantRepository.findAllById(ids);
    }

    public Participant updateParticipant(Participant participant) {
        return participantRepository.save(participant);
    }

    public void deleteParticipant(Long id) {
        participantRepository.deleteById(id);
    }
}

