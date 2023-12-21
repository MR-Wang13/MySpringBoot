package com.example.myspringboot.entity;
import javax.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Clinicians")
public class Clinician {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clinicianId;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
