package com.example.QUIZAPP.dao;

import com.example.QUIZAPP.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {
   List<Question> findByCategory( String category);
   @Query("SELECT q FROM Question q WHERE q.category = :category ORDER BY RAND() LIMIT :numQ")
   List<Question> findRandomQuestionsByCategory(@Param("category") String category, @Param("numQ") Integer numQ);

}
