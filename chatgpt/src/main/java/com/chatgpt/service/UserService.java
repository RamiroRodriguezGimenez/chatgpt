package com.chatgpt.service;

import com.chatgpt.dto.*;
import com.chatgpt.model.*;
import com.chatgpt.model.Record;
import com.chatgpt.repository.IRecordRepository;
import com.chatgpt.repository.IRoleRepository;
import com.chatgpt.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    IUserRepository userRepository;
    @Autowired
    IRoleRepository roleRepository;
    @Autowired
    IRecordRepository recordRepository;
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public void create(UserRequestDTO request){
        Role role=roleRepository.findByRole(request.getRole());
        User user=new User(request, role);
        userRepository.save(user);
    }

    public List<UserResponseDTO> get(){
        List<User> users= userRepository.findUsersWithZeroBalanceAndRecords();
        List<UserResponseDTO> usersDTO= users.stream()
                .map(user -> modelMapper().map(user, UserResponseDTO.class))
                        .toList();
        return usersDTO;
    }
    public List<User> getByRole(String roleName){
        Role role=roleRepository.findByRole(roleName);
        List<User> userList = userRepository.findByRole(role);
        return userList;
     }

    public List<AdminResponseDTO> getAdmin() {
        List<Object[]> results = userRepository.findAdminUsersWithQuestionsAndRecords();
        List<AdminResponseDTO> adminsDTO = new ArrayList<>();

        for (Object[] result : results) {
            User user =(User) result[0];
            Question question = (Question) result[1];

            AdminResponseDTO adminDTO = new AdminResponseDTO();
            adminDTO.setFirstName(user.getFirstName());
            adminDTO.setLastName(user.getLastName());
            adminDTO.setPhone(user.getPhone());
            adminDTO.setQuestion(question.getQuestion());

            adminsDTO.add(adminDTO);
        }
        return adminsDTO;
    }

    public List<UserBetweenDateDTO> getBetweenDate(LocalDateTime startDate, LocalDateTime endDate) {
        List<Record> recordsDB= recordRepository.findUsersWithConsultationsInDateRange(startDate, endDate);
        List<UserBetweenDateDTO> users=new ArrayList<>();
        for (Record record: recordsDB) {
            UserBetweenDateDTO user= new UserBetweenDateDTO();
            user.setUserName(record.getUser().getUserName());
            user.setQuestion(record.getQuestion().getQuestion());
            user.setDate(record.getCreationDate());

            users.add(user);
        }
        return users;
    }


    public BalanceDTO getBalance(Long id) {
        Optional<User> response=userRepository.findById(id);
        if (response.isEmpty()){
            return null;
        }
        User user=response.get();
        BalanceDTO balanceDTO = new BalanceDTO();
        balanceDTO.setBalance(user.getBalance().getBalance());
        balanceDTO.setCurrency(user.getBalance().getCurrency().getCurrency());
        balanceDTO.setFirstName(user.getFirstName());
        balanceDTO.setLastName(user.getLastName());

        return balanceDTO;

    }
}
