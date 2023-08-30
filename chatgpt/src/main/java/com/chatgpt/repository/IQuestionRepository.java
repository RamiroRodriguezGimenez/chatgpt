package com.chatgpt.repository;

import com.chatgpt.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IQuestionRepository extends JpaRepository<Question, Long> {
    public Question findByQuestion(String question);
    @Query("SELECT q FROM Question q " +
            "WHERE NOT EXISTS (SELECT r FROM Record r WHERE r.question = q)")
    List<Question> findNotAnswered();
}
