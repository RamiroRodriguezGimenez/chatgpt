package com.chatgpt.controller;

import com.chatgpt.dto.QuestionRequest;
import com.chatgpt.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/count/{questionId}")
    public ResponseEntity<Object> count(@PathVariable Long questionId){
        String message =questionService.count(questionId);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/not-answered")
    public ResponseEntity<Object> getNotAnswered(){
        List<String> questions=questionService.getNotAnswered();
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @PostMapping("/new/{userId}")
    public ResponseEntity<Object> create(@RequestBody QuestionRequest request, @PathVariable Long userId){
        return questionService.create(request, userId);
    }
}
