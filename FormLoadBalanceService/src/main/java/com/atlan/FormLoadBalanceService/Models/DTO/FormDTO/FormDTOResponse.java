package com.atlan.FormLoadBalanceService.Models.DTO.FormDTO;

import com.atlan.FormLoadBalanceService.Models.DTO.QuestionDTO.QuestionDTOResponse;
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