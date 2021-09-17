package com.atlan.formService.Controller;

import com.atlan.formService.Models.Answer;
import com.atlan.formService.Models.Question;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuestionController {

    ResponseEntity<List<Question>> getQuestionByForm(Integer id);

    ResponseEntity<Question> add(Question question);
}
