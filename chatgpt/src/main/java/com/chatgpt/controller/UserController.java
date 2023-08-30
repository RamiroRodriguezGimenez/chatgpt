package com.chatgpt.controller;

import com.chatgpt.dto.*;
import com.chatgpt.model.User;
import com.chatgpt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/")
    public ResponseEntity<Object> createUser(@RequestBody UserRequestDTO request){
        userService.create(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/no-debtor")
    public ResponseEntity<Object> get(){
        List<UserResponseDTO> usersDTO=userService.get();
        return new ResponseEntity<>( usersDTO, HttpStatus.OK);
    }

    @GetMapping("/by-role/{role}")
    public ResponseEntity<Object> getByRole(@PathVariable String role){
        List<User> users=userService.getByRole(role);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/get-admin")
    public ResponseEntity<Object> getAdmin(){
        List<AdminResponseDTO> adminsDTO=userService.getAdmin();
        return new ResponseEntity<>( adminsDTO, HttpStatus.OK);
    }

    @GetMapping("/get-between-date")
    public ResponseEntity<Object> getBetweenDate(@RequestParam LocalDateTime startDate, @RequestParam LocalDateTime endDate){
        List<UserBetweenDateDTO> users= userService.getBetweenDate(startDate, endDate);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/balance/{id}")
    public ResponseEntity<Object> getBalance(@PathVariable Long id){
        BalanceDTO balance=userService.getBalance(id);
        if (balance==null){
            return new ResponseEntity<>("Usuario no encontrado", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(balance, HttpStatus.OK);
    }
}
