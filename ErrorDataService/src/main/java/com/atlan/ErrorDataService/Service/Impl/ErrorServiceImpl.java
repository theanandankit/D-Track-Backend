package com.atlan.ErrorDataService.Service.Impl;

import com.atlan.ErrorDataService.Models.Error;
import com.atlan.ErrorDataService.Models.ErrorDTORequest;
import com.atlan.ErrorDataService.Repositories.ErrorRepository;
import com.atlan.ErrorDataService.Service.ErrorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ErrorServiceImpl implements ErrorService {

    Logger logger = LoggerFactory.getLogger(ErrorServiceImpl.class);

    @Autowired
    private ErrorRepository repository;

    @Override
    public void saveError(ErrorDTORequest request) {

        try {
            Error error = new Error();
            error.setMessage(request.getMessage());
            error.setClassName(request.getClassName());
            error.setInstancePort(request.getInstancePort());
            error.setDateTime(new Date().toString());
            repository.save(error);
        } catch (Exception e) {
            logger.info("Problem with saving error message");
        }

    }

    @Override
    public List<Error> getAllError() {
        return repository.findAll();
    }
}
