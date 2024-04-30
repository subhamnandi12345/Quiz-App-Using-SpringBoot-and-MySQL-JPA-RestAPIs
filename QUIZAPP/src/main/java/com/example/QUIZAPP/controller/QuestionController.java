package com.example.QUIZAPP.controller;

import com.example.QUIZAPP.model.Question;
import com.example.QUIZAPP.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestion(){
        return questionService.getAllQuestions();
    }
    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getAllQuestionsByCatagory(@PathVariable String category){

        return questionService.getAllquestionsByCatagory(category);
    }

    @PostMapping("add")
    public ResponseEntity<String> add(@RequestBody Question question){
         return questionService.addQuestion(question);
    }
}
