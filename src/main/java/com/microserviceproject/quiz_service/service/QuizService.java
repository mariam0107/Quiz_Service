package com.microserviceproject.quiz_service.service;


import com.microserviceproject.quiz_service.dao.QuizDao;
import com.microserviceproject.quiz_service.feign.QuizInterface;
import com.microserviceproject.quiz_service.model.QuestionWrapper;
import com.microserviceproject.quiz_service.model.Quiz;
import com.microserviceproject.quiz_service.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;
   @Autowired
    QuizInterface quizInterface;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Integer> questions = quizInterface.getQuestionsForQuiz(category,numQ).getBody();
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);

    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
//        Optional<Quiz> quiz = quizDao.findById(id);
//        List<Question> questionsFromDB = quiz.get().getQuestions();
          List<QuestionWrapper> questionForUser = new ArrayList<>();
//        for(Question q: questionsFromDB){
//            QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getQuestiontitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
//            questionForUser.add(qw);
//        }
        return new ResponseEntity<>(questionForUser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
//        Quiz quiz = quizDao.findById(id).get();
//        List<Question> questions = quiz.getQuestions();
        int right = 0;
//        int i=0;
//        for(Response response:responses){
//            if(response.getResponse().equals(questions.get(i).getRightanswer()))
//                right++;
//            i++;
//        }
        return new ResponseEntity<>(right,HttpStatus.OK);
   }

}
