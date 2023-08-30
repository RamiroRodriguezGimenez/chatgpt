package com.chatgpt.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserBetweenDateDTO {
    private String userName;
    private String question;
    private LocalDateTime date;
}
