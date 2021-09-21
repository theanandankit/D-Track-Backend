package com.atlan.formService.Service.Impl;

import com.atlan.formService.Models.DTO.ErrorDTO.ErrorDTORequest;
import com.atlan.formService.Models.DTO.QuestionDTO.QuestionDTORequest;
import com.atlan.formService.Models.DTO.QuestionDTO.QuestionDTOResponse;
import com.atlan.formService.Repositories.QuestionRepository;
import com.atlan.formService.Models.Question;
import com.atlan.formService.Service.QuestionService;
import com.atlan.formService.Service.ResponseService;
import com.atlan.formService.Service.SendError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private SendError error;

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
        List<QuestionDTOResponse> result = new ArrayList<>();
        try {
            questionRepository.getAllByForm(id).forEach(response -> result.add(getQuestionDTOResponse(response)));
        } catch (Exception e) {
            error.SendError(new ErrorDTORequest(e.getMessage(), QuestionServiceImpl.class.getName()));
            return null;
        }
        return result;
    }

    @Override
    public QuestionDTOResponse add(QuestionDTORequest questionDTORequest) {
        Question question = new Question();
        question.setAnswer(questionDTORequest.getAnswer());
        question.setForm(questionDTORequest.getForm());
        question.setValue(questionDTORequest.getValue());
        question.setCreated(new Date().toString());

        try {
            question = questionRepository.save(question);
            System.out.println(question.getAnswer());
            return getQuestionDTOResponse(question);
        } catch (Exception e) {
            error.SendError(new ErrorDTORequest(e.getMessage(), QuestionServiceImpl.class.getName()));
            return null;
        }
    }

    private QuestionDTOResponse getQuestionDTOResponse(Question question) {
        QuestionDTOResponse response = new QuestionDTOResponse();
        response.setId(question.getId());
        response.setAnswer(question.getAnswer());
        response.setForm(question.getForm());
        response.setResponseList(responseService.getByQuestion(question.getId()));
        response.setValue(question.getValue());

        return response;
    }
}
