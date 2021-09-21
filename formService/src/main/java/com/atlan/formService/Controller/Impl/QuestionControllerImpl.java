package com.atlan.formService.Controller.Impl;

import com.atlan.formService.Controller.QuestionController;
import com.atlan.formService.Models.DTO.QuestionDTO.QuestionDTORequest;
import com.atlan.formService.Models.DTO.QuestionDTO.QuestionDTOResponse;
import com.atlan.formService.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestionControllerImpl implements QuestionController {

    @Autowired
    private QuestionService service;

    @Override
    @GetMapping("/question")
    public ResponseEntity<List<QuestionDTOResponse>> getQuestionByForm(@RequestParam("form") Integer id) {
        List<QuestionDTOResponse> result = service.getByForm(id);

        if (result == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok().body(result);
    }

    @Override
    @PostMapping("/question")
    public ResponseEntity<QuestionDTOResponse> add(@RequestBody QuestionDTORequest question) {

        QuestionDTOResponse result = service.add(question);

        if (result == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok().body(result);
    }
}
