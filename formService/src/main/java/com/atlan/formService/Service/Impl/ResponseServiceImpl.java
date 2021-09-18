package com.atlan.formService.Service.Impl;

import com.atlan.formService.Models.DTO.ResponseDTO.ResponseDTORequest;
import com.atlan.formService.Models.DTO.ResponseDTO.ResponseDTOResponse;
import com.atlan.formService.Repositories.ResponseRepository;
import com.atlan.formService.Models.Response;
import com.atlan.formService.Service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ResponseServiceImpl implements ResponseService {

    @Autowired
    private ResponseRepository dao;

    @Override
    public List<ResponseDTOResponse> getByQuestion(Integer id) {
        return null;
    }

    @Override
    public ResponseDTOResponse add(ResponseDTORequest responseDTORequest) {

        Response response = new Response();
        response.setCreated(new Date().toString());
        response.setQuestion(responseDTORequest.getQuestion());
        response.setValue(responseDTORequest.getValue());

        try {
            response = dao.save(response);
            ResponseDTOResponse result = new ResponseDTOResponse();
            result.setCreated(result.getCreated());
            result.setId(response.getId());
            result.setQuestion(response.getQuestion());
            result.setValue(response.getValue());

            return result;
        } catch (Exception e) {
            return null;
        }
    }
}
