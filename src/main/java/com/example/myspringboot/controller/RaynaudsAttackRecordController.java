package com.example.myspringboot.controller;
import com.example.myspringboot.entity.RaynaudsAttackRecord;
import com.example.myspringboot.service.RaynaudsAttackRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attacks")
public class RaynaudsAttackRecordController {

    @Autowired
    private RaynaudsAttackRecordService attackRecordService;

    @PostMapping
    public ResponseEntity<RaynaudsAttackRecord> createAttackRecord(@RequestBody RaynaudsAttackRecord record) {
        return ResponseEntity.ok(attackRecordService.saveAttackRecord(record));
    }

    @GetMapping
    public ResponseEntity<List<RaynaudsAttackRecord>> getAllAttackRecords() {
        return ResponseEntity.ok(attackRecordService.getAllAttackRecords());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RaynaudsAttackRecord> getAttackRecordById(@PathVariable Long id) {
        RaynaudsAttackRecord record = attackRecordService.getAttackRecordById(id);
        if (record != null) {
            return ResponseEntity.ok(record);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/participant/{participantId}")
    public ResponseEntity<List<RaynaudsAttackRecord>> getAttackRecordsByParticipantId(@PathVariable Long participantId) {
        return ResponseEntity.ok(attackRecordService.getAttackRecordsByParticipantId(participantId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAttackRecord(@PathVariable Long id) {
        attackRecordService.deleteAttackRecord(id);
        return ResponseEntity.ok().build();
    }
}
