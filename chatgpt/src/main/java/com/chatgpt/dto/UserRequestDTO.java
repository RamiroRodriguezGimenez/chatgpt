package com.chatgpt.dto;

import lombok.Data;

@Data
public class UserRequestDTO {

    private String userName;
    private  String role;
    private String firstName;
    private String lastName;
    private String phone;
    private String gender;
    private String country;
}
