package com.example.myspringboot.service;
import com.example.myspringboot.entity.RaynaudsAttackRecord;
import com.example.myspringboot.repository.RaynaudsAttackRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaynaudsAttackRecordService {

    @Autowired
    private RaynaudsAttackRecordRepository attackRecordRepository;

    public RaynaudsAttackRecord saveAttackRecord(RaynaudsAttackRecord record) {
        return attackRecordRepository.save(record);
    }

    public List<RaynaudsAttackRecord> getAllAttackRecords() {
        return attackRecordRepository.findAll();
    }

    public RaynaudsAttackRecord getAttackRecordById(Long id) {
        return attackRecordRepository.findById(id).orElse(null);
    }

    public void deleteAttackRecord(Long id) {
        attackRecordRepository.deleteById(id);
    }

    public List<RaynaudsAttackRecord> getAttackRecordsByParticipantId(Long participantId) {
        return attackRecordRepository.findByParticipantId(participantId);
    }
}
