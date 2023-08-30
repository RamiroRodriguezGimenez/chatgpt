package com.chatgpt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;



@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name="BALANCE",schema = "chatgpt")
public class Balance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name = "native")
    private Long id;
    private Long balance;
    private int freeQuestion;
    @ManyToOne
    private Currency currency;

    public Balance(Long balance, int freeQuestion) {
        this.balance = balance;
        this.freeQuestion = freeQuestion;
    }
}
