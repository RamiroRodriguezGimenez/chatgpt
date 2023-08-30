package com.chatgpt.dto;

import com.chatgpt.model.Role;
import lombok.Data;

@Data
public class UserResponseDTO {

    private String userName;
    private String firstName;
    private String country;
    private Role role;

}
