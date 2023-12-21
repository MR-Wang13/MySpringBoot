package com.example.myspringboot.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

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
    private LocalDate attackDate;

    @Column(nullable = false)
    private LocalTime attackTime;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Location location;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    public enum Location {
        INSIDE, OUTSIDE
    }

}

