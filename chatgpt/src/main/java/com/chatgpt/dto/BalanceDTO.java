package com.chatgpt.dto;

import com.chatgpt.model.Currency;
import lombok.Data;

@Data
public class BalanceDTO {
    private String firstName;
    private String lastName;
    private Long balance;
    private String currency;
}
