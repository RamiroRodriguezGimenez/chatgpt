package com.chatgpt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;


import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name="QUESTION",schema = "chatgpt")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name = "native")
    private Long id;
    private String question;
    private LocalDateTime creationDate;
    @ManyToOne
    @JsonIgnore
    private User user;
    @ManyToOne
    private Answer answer;

    public Question(String question,  User user, Answer answer) {
        this.question = question;
        this.creationDate = LocalDateTime.now();
        this.user = user;
        this.answer=answer;
    }
    public Question(String question,  User user) {
        this.question = question;
        this.creationDate = LocalDateTime.now();
        this.user = user;
    }
}
