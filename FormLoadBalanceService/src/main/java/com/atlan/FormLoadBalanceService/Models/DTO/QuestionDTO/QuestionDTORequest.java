package com.atlan.FormLoadBalanceService.Models.DTO.QuestionDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDTORequest {

    private String value;

    private String answer;

    private Integer form;

}
