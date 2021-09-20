package com.atlan.ErrorDataService.Service;

import com.atlan.ErrorDataService.Models.Error;
import com.atlan.ErrorDataService.Models.ErrorDTORequest;

import java.util.List;

public interface ErrorService {

    void saveError(ErrorDTORequest request);

    List<Error> getAllError();
}
