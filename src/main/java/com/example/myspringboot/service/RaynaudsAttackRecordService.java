package com.example.myspringboot.service;
import com.example.myspringboot.entity.RaynaudsAttackRecord;
import com.example.myspringboot.repository.RaynaudsAttackRecordRepository;
import com.example.myspringboot.vo.ChartDataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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


    public List<RaynaudsAttackRecord> getTodayRecordsByParticipantId(Long participantId) {
        return attackRecordRepository.getTodayRecordsByParticipantId(participantId);
    }

    public ChartDataVo getChartDataByParticipantId(Long participantId) {
        ChartDataVo vo = new ChartDataVo();
        List<RaynaudsAttackRecord> records = attackRecordRepository.getPastSevenDaysRecordsByParticipantId(participantId);
        if (CollectionUtils.isEmpty(records)){
            return vo;
        }
        resolveRecords(records,vo);
        return vo;
    }

    private void resolveRecords(List<RaynaudsAttackRecord> records, ChartDataVo vo) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Map<String, Long> dateCounts = records.stream()
                .collect(Collectors.groupingBy(
                        record -> record.getAttackDate().format(dateFormat),
                        Collectors.counting()));
        List<String> dateList = new ArrayList<>(dateCounts.keySet());

        vo.setDays(dateList);
        vo.setNums(dateList.stream()
                .map(dateCounts::get)
                .collect(Collectors.toList()));
    }
}
