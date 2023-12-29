package com.example.myspringboot.controller;
import com.example.myspringboot.entity.Participant;
import com.example.myspringboot.service.ParticipantService;
import com.example.myspringboot.vo.CheckUserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/participants")
@Api(description = "APIs related to Participant ",tags = "ParticipantController")
public class ParticipantController {

    @Autowired
    private ParticipantService participantService;

    @PostMapping
    @ApiOperation(value = "createParticipant" , notes = "createParticipant")
    public ResponseEntity<?> createParticipant(@RequestBody Participant participant) {
        return ResponseEntity.ok(participantService.saveParticipant(participant));
    }

    @GetMapping
    @ApiOperation(value = "getAllParticipants" , notes = "getAllParticipants")
    public ResponseEntity<List<Participant>> getAllParticipants() {
        return ResponseEntity.ok(participantService.getAllParticipants());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "getParticipantById" , notes = "getParticipantById")
    public ResponseEntity<Participant> getParticipantById(@PathVariable Long id) {
        Participant participant = participantService.getParticipantById(id);
        if (participant != null) {
            return ResponseEntity.ok(participant);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "updateParticipant" , notes = "updateParticipant")
    public ResponseEntity<Participant> updateParticipant(@PathVariable Long id, @RequestBody Participant participantDetails) {
        Participant participant = participantService.getParticipantById(id);
        if (participant != null) {
            participant.setUsername(participantDetails.getUsername());
            participant.setDeviceUuid(participantDetails.getDeviceUuid());
            return ResponseEntity.ok(participantService.updateParticipant(participant));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "deleteParticipant" , notes = "deleteParticipant")
    public ResponseEntity<?> deleteParticipant(@PathVariable Long id) {
        participantService.deleteParticipant(id);
        return ResponseEntity.ok().build();
    }
}

