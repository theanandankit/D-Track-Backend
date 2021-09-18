package com.atlan.formService.Models.DTO.FormDTO;

import com.atlan.formService.Models.DTO.QuestionDTO.QuestionDTOResponse;
import com.atlan.formService.Models.Question;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FormDTOResponse {

    private Integer id;

    private String title;

    private List<QuestionDTOResponse> questionList;

    private String created;
}