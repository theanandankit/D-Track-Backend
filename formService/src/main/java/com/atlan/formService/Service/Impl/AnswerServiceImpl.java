package com.atlan.formService.Service.Impl;

import com.atlan.formService.Dao.AnswerDao;
import com.atlan.formService.Models.Answer;
import com.atlan.formService.Service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerDao dao;

    @Override
    public Answer add(Answer answer) {
        try {
            return dao.save(answer);
        } catch (Exception e) {
            return null;
        }
    }
}
