package com.example.QUIZAPP.service;

import com.example.QUIZAPP.model.Question;
import com.example.QUIZAPP.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Question>> getAllQuestions() {
        try{
            return  new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK) ;
        }catch (Exception e){
            e.printStackTrace();
        }
      return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getAllquestionsByCatagory(String category) {
        try{
            return  new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Question question) {
        try {
                questionDao.save(question);
                return new ResponseEntity<>("success", HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
        }
         return  new ResponseEntity<>("Not able to create",HttpStatus.BAD_REQUEST);
    }
}
