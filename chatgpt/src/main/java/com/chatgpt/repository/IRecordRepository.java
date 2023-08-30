package com.chatgpt.repository;

import com.chatgpt.model.Question;
import com.chatgpt.model.Record;
import com.chatgpt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IRecordRepository extends JpaRepository<Record, Long> {
    @Query("SELECT COUNT(r) FROM Record r WHERE r.question = :question")
    int count(Question question);

    @Query("SELECT DISTINCT r FROM Record r " +
            "WHERE r.creationDate BETWEEN :startDate AND :endDate")
    List<Record> findUsersWithConsultationsInDateRange(@Param("startDate") LocalDateTime startDate,
                                                     @Param("endDate") LocalDateTime endDate);

}
