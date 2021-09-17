package com.atlan.formService.Service.Impl;

import com.atlan.formService.Dao.ResponseDao;
import com.atlan.formService.Models.Question;
import com.atlan.formService.Models.Response;
import com.atlan.formService.Service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponseServiceImpl implements ResponseService {

    @Autowired
    private ResponseDao dao;

    @Override
    public List<Response> getByQuestion(Integer id) {
        return null;
    }

    @Override
    public Response add(Response response) {
        try {
            return dao.save(response);
        } catch (Exception e) {
            return null;
        }
    }
}
