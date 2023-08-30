package com.chatgpt.dto;

import com.chatgpt.model.Question;
import lombok.Data;

@Data
public class AdminResponseDTO {
    private String firstName;
    private String lastName;
    private String phone;
    private String question;
}
