package com.atlan.formService.Controller;

import com.atlan.formService.Models.DTO.QuestionDTO.QuestionDTORequest;
import com.atlan.formService.Models.DTO.QuestionDTO.QuestionDTOResponse;
import com.atlan.formService.Models.Question;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuestionController {

    ResponseEntity<List<QuestionDTOResponse>> getQuestionByForm(Integer id);

    ResponseEntity<QuestionDTOResponse> add(QuestionDTORequest question);
}
