package com.atlan.formService.Service.Impl;

import com.atlan.formService.Dao.QuestionDao;
import com.atlan.formService.Models.Form;
import com.atlan.formService.Models.Question;
import com.atlan.formService.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionDao dao;

    @Override
    public List<Question> getByForm(Form form) {
        return null;
    }

    @Override
    public Question add(Question question) {
        return dao.save(question);
    }
}
