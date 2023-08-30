package com.chatgpt.controller;

import com.chatgpt.model.Answer;
import com.chatgpt.model.Question;
import com.chatgpt.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    ChatService chatService;

    @GetMapping("")
    public String chat(@RequestParam String question, @RequestParam String userName){
        return chatService.chat(question, userName);
    }
}
