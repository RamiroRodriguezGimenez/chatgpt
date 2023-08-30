package com.chatgpt.service;

import com.chatgpt.model.*;
import com.chatgpt.model.Record;
import com.chatgpt.repository.IBalanceRepository;
import com.chatgpt.repository.IQuestionRepository;
import com.chatgpt.repository.IRecordRepository;
import com.chatgpt.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ChatService {
    @Autowired
    IQuestionRepository questionRepository;
    @Autowired
    IRecordRepository recordRepository;
    @Autowired
    IUserRepository userRepository;
    @Autowired
    IBalanceRepository balanceRepository;
    public final Long price=10L;
    public String chat(String question, String userName){
        Answer answer;
        Record record;
        User user = userRepository.findByUserName(userName);
        List<Question> questions =questionRepository.findAll()
                .stream().filter(y -> y.getQuestion().toLowerCase()
                        .contains(question.toLowerCase())).toList();
        if (questions.isEmpty()){
            answer= new Answer("no puedo darle informacion sobre ese tema");
        } else {
            answer=questions.get(0).getAnswer();
            record = new Record(user, questions.get(0));
            recordRepository.save(record);

        }

        setBalance(user.getBalance());
        return answer.getAnswer();
    }

    public void setBalance(Balance balance){

        if (balance.getFreeQuestion() <= 0){
            balance.setBalance(balance.getBalance()+(price*balance.getCurrency().getConverter()));
      } else {
        balance.setFreeQuestion(balance.getFreeQuestion()-1);
        }
        balanceRepository.save(balance);
    }
}
