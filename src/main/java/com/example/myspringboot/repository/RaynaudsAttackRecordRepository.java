package com.example.myspringboot.repository;
import com.example.myspringboot.entity.RaynaudsAttackRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RaynaudsAttackRecordRepository extends JpaRepository<RaynaudsAttackRecord, Long> {
    List<RaynaudsAttackRecord> findByParticipantId(Long participantId);

    @Query(value = "from RaynaudsAttackRecord where participantId=:participantId and attackDate >=CURRENT_DATE - 7 order by attackDate ")
    List<RaynaudsAttackRecord> getPastSevenDaysRecordsByParticipantId(@Param("participantId") Long participantId);
}

