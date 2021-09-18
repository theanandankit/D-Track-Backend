package com.atlan.formService.Models.DTO.QuestionDTO;

import com.atlan.formService.Models.DTO.ResponseDTO.ResponseDTOResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDTOResponse {

    private Integer Id;

    private String value;

    private String answer;

    private Integer form;

    private List<ResponseDTOResponse> responseList;

}
