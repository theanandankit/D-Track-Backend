package com.atlan.formService.Controller;

import com.atlan.formService.Models.DTO.ResponseDTO.ResponseDTORequest;
import com.atlan.formService.Models.DTO.ResponseDTO.ResponseDTOResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ResponseController {

    ResponseEntity<List<ResponseDTOResponse>> getResponseByQuestion(Integer id);

    ResponseEntity<ResponseDTOResponse> add(ResponseDTORequest response);

}
