package com.atlan.formService.Service.Impl;

import com.atlan.formService.Dao.FormDao;
import com.atlan.formService.Models.Form;
import com.atlan.formService.Service.FormService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormServiceImpl implements FormService {

    Logger logger = LoggerFactory.getLogger(FormServiceImpl.class);

    @Autowired
    private FormDao dao;

    @Override
    public List<Form> getAll() {
        return dao.findAll();
    }

    @Override
    public Form get(Integer id) {
        try {
            return dao.getById(id);
        } catch (Exception e) {
            logger.info("Form not found");
             return null;
        }
    }

    @Override
    public Form add(Form form) {
        try{
            return dao.save(form);
        } catch (Exception e) {
            return null;
        }
    }
}
