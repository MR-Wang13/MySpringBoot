package com.example.myspringboot.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "Raynauds_Attack_Records")
public class RaynaudsAttackRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attackId;

    @Column(nullable = false)
    private Long participantId;

    @Column(nullable = false)
    private LocalDateTime attackDate;


    @Column(nullable = false)
    private String location;


}

