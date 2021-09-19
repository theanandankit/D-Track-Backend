package com.atlan.DatabaseExportService.Service;

import com.atlan.DatabaseExportService.Models.DTO.ResponseDTOResponse;

import java.util.List;

public interface ResponseService {

    List<ResponseDTOResponse> getAllByQuestion(Integer id);

    List<ResponseDTOResponse> getAll();

}
