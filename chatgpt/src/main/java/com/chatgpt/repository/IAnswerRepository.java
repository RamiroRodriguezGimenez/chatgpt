package com.chatgpt.repository;

import com.chatgpt.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAnswerRepository extends JpaRepository<Answer, Long> {
    Answer findByAnswer(String answer);
}
