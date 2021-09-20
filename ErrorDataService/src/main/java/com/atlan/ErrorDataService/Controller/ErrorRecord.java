package com.atlan.ErrorDataService.Controller;

import com.atlan.ErrorDataService.Models.Error;
import com.atlan.ErrorDataService.Models.ErrorDTORequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ErrorRecord {

    ResponseEntity<List<Error>> getAll();

    void record(ErrorDTORequest errorDTORequest);
}
