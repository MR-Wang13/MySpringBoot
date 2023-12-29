package com.example.myspringboot.vo;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class DashboardRecordListVo {
    private Long participantId;

    private String username;

    private String warning;

    private LocalDateTime lastReportTime;

}
