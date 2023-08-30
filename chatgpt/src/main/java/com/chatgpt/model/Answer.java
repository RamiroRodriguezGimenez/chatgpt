package com.chatgpt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name="ANSWER",schema = "chatgpt")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name = "native")
    private Long id;
    private String answer;
    @OneToMany(mappedBy="answer")
    private List<Question> questionList= new ArrayList<>();

    public Answer(String answer) {
        this.answer = answer;
    }
    public void addQuestion(Question question){
        questionList.add(question);
    }
}
