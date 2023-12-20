package com.example.myspringboot.repository;
import com.example.myspringboot.entity.RaynaudsAttackRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RaynaudsAttackRecordRepository extends JpaRepository<RaynaudsAttackRecord, Long> {
    List<RaynaudsAttackRecord> findByParticipantId(Long participantId);
}

