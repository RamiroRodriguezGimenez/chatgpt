package com.chatgpt.model;

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
@Table(name="RECORD",schema = "chatgpt")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name = "native")
    private Long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Question question;
    private LocalDateTime creationDate;

    public Record(User user, Question question) {
        this.user = user;
        this.question = question;
        this.creationDate = LocalDateTime.now();
    }
}
