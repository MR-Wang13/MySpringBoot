package com.example.myspringboot.controller;
import com.example.myspringboot.entity.RaynaudsAttackRecord;
import com.example.myspringboot.service.RaynaudsAttackRecordService;
import com.example.myspringboot.vo.ChartDataVo;
import com.example.myspringboot.vo.DashboardRecordListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attacks")
@Api(description = "APIs related to RaynaudsAttackRecord ",tags = "RaynaudsAttackRecordController")
public class RaynaudsAttackRecordController {

    @Autowired
    private RaynaudsAttackRecordService attackRecordService;

    @PostMapping
    @ApiOperation(value = "createAttackRecord" , notes = "createAttackRecord")
    public ResponseEntity<RaynaudsAttackRecord> createAttackRecord(@RequestBody RaynaudsAttackRecord record) {
        return ResponseEntity.ok(attackRecordService.saveAttackRecord(record));
    }

    @GetMapping
    @ApiOperation(value = "getAllAttackRecords" , notes = "getAllAttackRecords")
    public ResponseEntity<List<RaynaudsAttackRecord>> getAllAttackRecords() {
        return ResponseEntity.ok(attackRecordService.getAllAttackRecords());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "getAttackRecordById" , notes = "getAttackRecordById")
    public ResponseEntity<RaynaudsAttackRecord> getAttackRecordById(@PathVariable Long id) {
        RaynaudsAttackRecord record = attackRecordService.getAttackRecordById(id);
        if (record != null) {
            return ResponseEntity.ok(record);
        } else {
            return ResponseEntity.ok(null);
        }
    }

    @GetMapping("/participant/{participantId}")
    @ApiOperation(value = "getAttackRecordsByParticipantId" , notes = "getAttackRecordsByParticipantId")
    public ResponseEntity<List<RaynaudsAttackRecord>> getAttackRecordsByParticipantId(@PathVariable Long participantId) {
        return ResponseEntity.ok(attackRecordService.getAttackRecordsByParticipantId(participantId));
    }

    @GetMapping("/participant/today/{participantId}")
    @ApiOperation(value = "getTodayRecordsByParticipantId" , notes = "getTodayRecordsByParticipantId")
    public ResponseEntity<List<RaynaudsAttackRecord>> getTodayRecordsByParticipantId(@PathVariable Long participantId) {
        return ResponseEntity.ok(attackRecordService.getTodayRecordsByParticipantId(participantId));
    }

    @GetMapping("/getChartData/{participantId}")
    @ApiOperation(value = "getChartDataByParticipantId" , notes = "getChartDataByParticipantId")
    public ResponseEntity<ChartDataVo> getChartDataByParticipantId(@PathVariable Long participantId) {
        return ResponseEntity.ok(attackRecordService.getChartDataByParticipantId(participantId));
    }

    @GetMapping("/getDashboardChartData")
    @ApiOperation(value = "getChartDataByParticipantId" , notes = "getChartDataByParticipantId")
    public ResponseEntity<ChartDataVo> getDashboardChartData() {
        return ResponseEntity.ok(attackRecordService.getDashboardChartData());
    }

    @GetMapping("/getDashboardList")
    @ApiOperation(value = "getChartDataByParticipantId" , notes = "getDashboardList")
    public ResponseEntity<List<DashboardRecordListVo>> getDashboardList() {
        return ResponseEntity.ok(attackRecordService.getDashboardList());
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "deleteAttackRecord" , notes = "deleteAttackRecord")
    public ResponseEntity<?> deleteAttackRecord(@PathVariable Long id) {
        attackRecordService.deleteAttackRecord(id);
        return ResponseEntity.ok().build();
    }
}
