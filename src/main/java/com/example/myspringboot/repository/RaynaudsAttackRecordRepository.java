package com.example.myspringboot.repository;
import com.example.myspringboot.entity.RaynaudsAttackRecord;
import com.example.myspringboot.vo.DashboardRecordListVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RaynaudsAttackRecordRepository extends JpaRepository<RaynaudsAttackRecord, Long> {
    @Query(value = "from RaynaudsAttackRecord where participantId=:participantId order by attackDate desc")
    List<RaynaudsAttackRecord> findByParticipantId(Long participantId);

    @Query(value = "from RaynaudsAttackRecord where participantId=:participantId and attackDate >=CURRENT_DATE - 7 order by attackDate ")
    List<RaynaudsAttackRecord> getPastSevenDaysRecordsByParticipantId(@Param("participantId") Long participantId);

    @Query(value = "from RaynaudsAttackRecord where  attackDate >=CURRENT_DATE - 7 order by attackDate ")
    List<RaynaudsAttackRecord> getPastSevenDaysRecords();

    @Query(value = "from RaynaudsAttackRecord where participantId=:participantId and attackDate >= CURRENT_DATE AND attackDate < CURRENT_DATE + 1 order by attackDate ")
    List<RaynaudsAttackRecord> getTodayRecordsByParticipantId(@Param("participantId")Long participantId);

    @Query("SELECT ar FROM RaynaudsAttackRecord ar WHERE ar.attackDate IN (SELECT MAX(a.attackDate) FROM RaynaudsAttackRecord a WHERE a.participantId = ar.participantId GROUP BY a.participantId) order by  ar.attackDate")
    List<RaynaudsAttackRecord> findLatestAttackDatesForAllUsers();
}

