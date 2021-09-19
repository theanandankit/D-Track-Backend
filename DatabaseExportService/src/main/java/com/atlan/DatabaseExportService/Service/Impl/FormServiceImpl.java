package com.atlan.DatabaseExportService.Service.Impl;

import com.atlan.DatabaseExportService.Models.DTO.FormDTOResponse;
import com.atlan.DatabaseExportService.Models.Form;
import com.atlan.DatabaseExportService.Models.Response;
import com.atlan.DatabaseExportService.Repositories.FormRepository;
import com.atlan.DatabaseExportService.Service.FormService;
import com.atlan.DatabaseExportService.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FormServiceImpl implements FormService {

    @Autowired
    private FormRepository repository;

    @Autowired
    private QuestionService questionService;

    @Override
    public List<FormDTOResponse> getAllResult() {

        List<FormDTOResponse> result = new ArrayList<>();

        repository.findAll().forEach(form -> result.add(getFormDTO(form)));
        return result;
    }

    private FormDTOResponse getFormDTO(Form form) {
        FormDTOResponse response = new FormDTOResponse();
        response.setId(form.getId());
        response.setCreated(form.getCreated());
        response.setQuestionList(questionService.getAllByForm(form.getId()));
        response.setTitle(form.getTitle());

        return  response;
    }
}
