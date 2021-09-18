package com.atlan.formService.Service.Impl;

import com.atlan.formService.Models.DTO.FormDTO.FormDTORequest;
import com.atlan.formService.Models.DTO.FormDTO.FormDTOResponse;
import com.atlan.formService.Repositories.FormRepository;
import com.atlan.formService.Models.Form;
import com.atlan.formService.Service.FormService;
import com.atlan.formService.Service.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FormServiceImpl implements FormService {

    Logger logger = LoggerFactory.getLogger(FormServiceImpl.class);

    @Autowired
    private FormRepository formRepository;

    @Autowired
    private QuestionService questionService;

    @Override
    public List<FormDTOResponse> getAll() {

        List<FormDTOResponse> result = new ArrayList<>();

        formRepository.findAll().forEach(form -> {
            FormDTOResponse response = new FormDTOResponse();
            response.setId(form.getId());
            response.setCreated(form.getCreated());
            response.setQuestionList(questionService.getByForm(form.getId()));
            response.setTitle(form.getTitle());
        });

        return result;
    }

    @Override
    public FormDTOResponse get(Integer id) {
        try {
            Form form = formRepository.getById(id);
            FormDTOResponse response = new FormDTOResponse();
            response.setTitle(form.getTitle());
            response.setId(form.getId());
            response.setCreated(form.getCreated());
            response.setQuestionList(questionService.getByForm(form.getId()));

            return response;
        } catch (Exception e) {
            logger.info("Form not found");
             return null;
        }
    }

    @Override
    public FormDTOResponse add(FormDTORequest formDao) {
        Form form = new Form();
        form.setTitle(formDao.getTitle());
        form.setCreated(new Date().toString());
        try{
            form = formRepository.save(form);
            FormDTOResponse response = new FormDTOResponse();
            response.setId(form.getId());
            response.setCreated(form.getCreated());
            response.setTitle(form.getTitle());
            return response;
        } catch (Exception e) {
            return null;
        }
    }
}
