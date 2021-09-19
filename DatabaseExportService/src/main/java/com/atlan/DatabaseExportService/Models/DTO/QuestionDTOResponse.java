package com.atlan.DatabaseExportService.Models.DTO;

import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDTOResponse {

    private Integer Id;

    private String value;

    private String answer;

    private Integer form;

    private List<ResponseDTOResponse> responseList;
}