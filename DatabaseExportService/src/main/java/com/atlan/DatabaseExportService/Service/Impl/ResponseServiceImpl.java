package com.atlan.DatabaseExportService.Service.Impl;

import com.atlan.DatabaseExportService.Models.DTO.ResponseDTOResponse;
import com.atlan.DatabaseExportService.Models.Response;
import com.atlan.DatabaseExportService.Repositories.ResponseRepository;
import com.atlan.DatabaseExportService.Service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResponseServiceImpl implements ResponseService {

    @Autowired
    private ResponseRepository repository;

    @Override
    public List<ResponseDTOResponse> getAllByQuestion(Integer id) {
        List<ResponseDTOResponse> result = new ArrayList<>();

        repository.getAllByQuestion(id).forEach(response -> result.add(getResponseDTO(response)));
        return result;
    }

    @Override
    public List<ResponseDTOResponse> getAll() {

        List<ResponseDTOResponse> result = new ArrayList<>();

        repository.findAll().forEach(response -> result.add(getResponseDTO(response)));

        return result;
    }

    private ResponseDTOResponse getResponseDTO(Response response) {
        ResponseDTOResponse temp = new ResponseDTOResponse();
        temp.setId(response.getId());
        temp.setValue(response.getValue());
        temp.setQuestion(response.getQuestion());
        temp.setCreated(response.getCreated());

        return temp;
    }
}
