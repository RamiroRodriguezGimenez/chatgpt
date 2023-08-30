package com.chatgpt.model;

import com.chatgpt.dto.UserRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name="USERS",schema = "chatgpt")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name = "native")
    private Long id;
    private String userName;
    private LocalDate creationDate;
    private String firstName;
    private String lastName;
    private String phone;
    private String gender;
    private String country;
    @ManyToOne
    private Role role;
    @OneToOne
    private Balance balance;


    public User(String userName, String firstName, String lastName, String phone, String gender, String country) {
        this.userName = userName;
        this.creationDate = LocalDate.now();
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.gender = gender;
        this.country = country;
        this.balance=new Balance(0L,3);
    }

    public User(UserRequestDTO request, Role role){
        this.userName = request.getUserName();
        this.creationDate = LocalDate.now();
        this.firstName = request.getFirstName();
        this.lastName = request.getLastName();
        this.phone = request.getPhone();
        this.gender = request.getGender();
        this.country = request.getCountry();
        this.role=role;
        this.balance=new Balance(0L,3);
    }
}
