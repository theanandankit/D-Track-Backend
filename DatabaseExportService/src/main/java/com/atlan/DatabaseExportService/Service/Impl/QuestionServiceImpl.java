package com.atlan.DatabaseExportService.Service.Impl;

import com.atlan.DatabaseExportService.Models.DTO.QuestionDTOResponse;
import com.atlan.DatabaseExportService.Models.Question;
import com.atlan.DatabaseExportService.Repositories.QuestionRepository;
import com.atlan.DatabaseExportService.Service.QuestionService;
import com.atlan.DatabaseExportService.Service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository repository;

    @Autowired
    private ResponseService responseService;

    @Override
    public List<QuestionDTOResponse> getAllByForm(Integer id) {
        List<QuestionDTOResponse> responseList = new ArrayList<>();

        repository.getAllByForm(id).forEach(response -> responseList.add(getQuestionDTO(response)));
        return responseList;
    }

    @Override
    public List<QuestionDTOResponse> getAll() {

        List<QuestionDTOResponse> result = new ArrayList<>();

        repository.findAll().forEach(response -> result.add(getQuestionDTO(response)));
        return result;
    }

    private QuestionDTOResponse getQuestionDTO(Question response) {
        QuestionDTOResponse temp = new QuestionDTOResponse();
        temp.setId(response.getId());
        temp.setValue(response.getValue());
        temp.setAnswer(response.getAnswer());
        temp.setForm(response.getForm());
        temp.setResponseList(responseService.getAllByQuestion(response.getId()));

        return temp;
    }
}
