package com.atlan.formService.Controller;

import com.atlan.formService.Models.Answer;
import org.springframework.http.ResponseEntity;

public interface AnswerController {

    ResponseEntity<Answer> add(Answer answer);

}
