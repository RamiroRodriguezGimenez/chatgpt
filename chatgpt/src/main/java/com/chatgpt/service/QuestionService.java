package com.chatgpt.service;

import com.chatgpt.dto.QuestionRequest;
import com.chatgpt.model.Answer;
import com.chatgpt.model.Question;
import com.chatgpt.model.User;
import com.chatgpt.repository.IAnswerRepository;
import com.chatgpt.repository.IQuestionRepository;
import com.chatgpt.repository.IRecordRepository;
import com.chatgpt.repository.IUserRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    IRecordRepository recordRepository;
    @Autowired
    IQuestionRepository questionRepository;
    @Autowired
    IUserRepository userRepository;
    @Autowired
    IAnswerRepository answerRepository;
    public String count(Long id) {
        Optional<Question> response=questionRepository.findById(id);
        if (response.isEmpty()){
            return("pregunta no encontrada");
        }
        Question question=response.get();
        int questioned= recordRepository.count(question);
        return ("la pregunta se ha preguntado "+questioned+" veces.");
    }

    public List<String> getNotAnswered(){
        List<Question> questions=questionRepository.findNotAnswered();
        return questions.stream().map(question -> question.getQuestion()).toList();
    }

    public ResponseEntity<Object> create(QuestionRequest request, Long userId) {
        Optional<User> response = userRepository.findById(userId);
        if (response.isEmpty() || !response.get().getRole().getRole().equals("ADMIN")){
            return new ResponseEntity<>("Debe ser admin para crear pregunta", HttpStatus.UNAUTHORIZED);
        }
        Answer answer=answerRepository.findByAnswer(request.getAnswer());
        if (answer==null){
            answer=new Answer(request.getAnswer());
        }
        Question question= new Question(request.getQuestion(), response.get());
        questionRepository.save(question);
        answer.addQuestion(question);
        answerRepository.save(answer);
        question.setAnswer(answer);
        questionRepository.save(question);
        return new ResponseEntity<>("pregunta creada", HttpStatus.CREATED);

    }
}
