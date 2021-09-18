package com.atlan.formService.Service;

import com.atlan.formService.Models.DTO.QuestionDTO.QuestionDTORequest;
import com.atlan.formService.Models.DTO.QuestionDTO.QuestionDTOResponse;

import java.util.List;

public interface QuestionService {

    QuestionDTOResponse getById(Integer id);

    List<QuestionDTOResponse> getByForm(Integer id);

    QuestionDTOResponse add(QuestionDTORequest question);
}
