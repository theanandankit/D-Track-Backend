package com.atlan.formService.Service.Impl;

import com.atlan.formService.Models.DTO.ResponseDTO.ResponseDTORequest;
import com.atlan.formService.Models.DTO.ResponseDTO.ResponseDTOResponse;
import com.atlan.formService.Repositories.ResponseRepository;
import com.atlan.formService.Models.Response;
import com.atlan.formService.Service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ResponseServiceImpl implements ResponseService {

    @Autowired
    private ResponseRepository responseRepository;

    @Override
    public List<ResponseDTOResponse> getByQuestion(Integer id) {
        List<ResponseDTOResponse> result = new ArrayList<>();

        responseRepository.getAllByQuestion(id).forEach(response -> result.add(getResponseDTO(response)));
        return result;
    }

    @Override
    public ResponseDTOResponse add(ResponseDTORequest responseDTORequest) {

        Response response = new Response();
        response.setCreated(new Date().toString());
        response.setQuestion(responseDTORequest.getQuestion());
        response.setValue(responseDTORequest.getValue());

        try {
            response = responseRepository.save(response);
            return getResponseDTO(response);
        } catch (Exception e) {
            return null;
        }
    }

    private ResponseDTOResponse getResponseDTO(Response response) {
        ResponseDTOResponse result = new ResponseDTOResponse();
        result.setCreated(response.getCreated());
        result.setId(response.getId());
        result.setQuestion(response.getQuestion());
        result.setValue(response.getValue());

        return result;
    }
}
