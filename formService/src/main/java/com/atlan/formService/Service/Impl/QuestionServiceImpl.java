package com.atlan.formService.Service.Impl;

import com.atlan.formService.Models.DTO.QuestionDTO.QuestionDTORequest;
import com.atlan.formService.Models.DTO.QuestionDTO.QuestionDTOResponse;
import com.atlan.formService.Repositories.QuestionRepository;
import com.atlan.formService.Models.Question;
import com.atlan.formService.Service.QuestionService;
import com.atlan.formService.Service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ResponseService responseService;

    @Override
    public QuestionDTOResponse getById(Integer id) {
        Question question = questionRepository.getById(id);
        return getQuestionDTOResponse(question);
    }

    @Override
    public List<QuestionDTOResponse> getByForm(Integer id) {
        // NTI
        return null;
    }

    @Override
    public QuestionDTOResponse add(QuestionDTORequest questionDTORequest) {
        Question question = new Question();
        question.setAnswer(questionDTORequest.getAnswer());
        question.setForm_id(questionDTORequest.getForm());
        question.setValue(questionDTORequest.getValue());
        question.setCreated(new Date().toString());

        try {
            question = questionRepository.save(question);
            return getQuestionDTOResponse(question);
        } catch (Exception e) {
            return null;
        }
    }

    private QuestionDTOResponse getQuestionDTOResponse(Question question) {
        QuestionDTOResponse response = new QuestionDTOResponse();
        response.setId(question.getId());
        response.setAnswer(question.getAnswer());
        response.setForm(question.getForm_id());
        response.setResponseList(responseService.getByQuestion(question.getId()));
        response.setValue(question.getValue());

        return response;
    }
}
