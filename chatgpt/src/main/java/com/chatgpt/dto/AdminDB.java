package com.chatgpt.dto;

import com.chatgpt.model.Question;
import com.chatgpt.model.User;
import lombok.Data;

@Data
public class AdminDB {
    private User user;
    private Question question;
}
