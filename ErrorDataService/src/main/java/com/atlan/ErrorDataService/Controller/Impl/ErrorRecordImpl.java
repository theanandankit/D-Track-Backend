package com.atlan.ErrorDataService.Controller.Impl;

import com.atlan.ErrorDataService.Controller.ErrorRecord;
import com.atlan.ErrorDataService.Models.Error;
import com.atlan.ErrorDataService.Models.ErrorDTORequest;
import com.atlan.ErrorDataService.Service.ErrorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ErrorRecordImpl implements ErrorRecord {

    Logger logger = LoggerFactory.getLogger(ErrorRecordImpl.class);

    @Autowired
    private ErrorService errorService;

    @Override
    @GetMapping("/getError")
    public ResponseEntity<List<Error>> getAll() {
        return ResponseEntity.ok().body(errorService.getAllError());
    }

    @Override
    @PostMapping("/sendError")
    public void record(ErrorDTORequest errorDTORequest) {
            errorService.saveError(errorDTORequest);
    }
}
