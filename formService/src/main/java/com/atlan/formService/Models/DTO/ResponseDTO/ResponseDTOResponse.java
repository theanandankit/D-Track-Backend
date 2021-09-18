package com.atlan.formService.Models.DTO.ResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTOResponse {

    private Integer id;

    private String value;

    private String created;

    private Integer question;
}
