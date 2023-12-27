package com.example.myspringboot.entity;

import lombok.Data;

import javax.persistence.*;

import javax.persistence.GenerationType;
import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "Participants")
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long participantId;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String deviceUuid;

}

