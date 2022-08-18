package com.example.demo.service;

import com.example.demo.entity.Answer;
import com.example.demo.entity.Question;
import com.example.demo.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService{

  @Autowired
    QuestionRepository questionRepository;

    @Override
    public Iterable<Question> findAll() {
        return questionRepository.findAll();
    }

  @Override
  public int findAnswerIdCorrect(int questionId) {
    Question question=questionRepository.findById(questionId).get();
    for (Answer answer : question.getAnswers()
            ) {
      if (answer.getCorrect()){
        return  answer.getId();
      }
    }
    return -1;
  }
}
