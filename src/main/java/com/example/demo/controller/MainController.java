package com.example.demo.controller;

import com.example.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller

public class MainController {

    @Autowired
    QuestionService questionService;



   @RequestMapping(method = RequestMethod.GET)
public String index(ModelMap modelMap){
    modelMap.put("questions",questionService.findAll());
    return "index";
}

    @RequestMapping( value ="submit" , method = RequestMethod.POST)
    public String submit(HttpServletRequest request){
       int score=0;
       String []questionsIds= request.getParameterValues("questionId");
        for (String questionId: questionsIds
             ) {
            int answerIdCorrect= questionService.findAnswerIdCorrect(Integer.parseInt(questionId));
            if (answerIdCorrect==Integer.parseInt(request.getParameter("question_" + questionId))){
                score++;
            }

        }
        request.setAttribute("score",score);
        return "result";
    }



}
