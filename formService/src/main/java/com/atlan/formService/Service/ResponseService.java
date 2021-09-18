package com.atlan.formService.Service;

import com.atlan.formService.Models.DTO.ResponseDTO.ResponseDTORequest;
import com.atlan.formService.Models.DTO.ResponseDTO.ResponseDTOResponse;
import com.atlan.formService.Models.Question;
import com.atlan.formService.Models.Response;

import java.util.List;

public interface ResponseService {

    List<ResponseDTOResponse> getByQuestion(Integer id);

    ResponseDTOResponse add(ResponseDTORequest response);
}
