package com.atlan.formService.Controller.Impl;

import com.atlan.formService.Controller.AnswerController;
import com.atlan.formService.Models.Answer;
import com.atlan.formService.Service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnswerControllerImpl implements AnswerController {

    @Autowired
    private AnswerService service;

    @Override
    @PostMapping("/answer")
    public ResponseEntity<Answer> add(@RequestBody Answer answer) {
        Answer result = service.add(answer);

        if (answer == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.ok().body(result);
    }
}
