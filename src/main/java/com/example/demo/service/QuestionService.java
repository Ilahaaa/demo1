package com.example.demo.service;

import com.example.demo.entity.Question;

public interface QuestionService {
    public Iterable<Question> findAll();
    public int findAnswerIdCorrect(int questionId);
}
