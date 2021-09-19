package com.atlan.DatabaseExportService.Service;

import com.atlan.DatabaseExportService.Models.DTO.QuestionDTOResponse;

import java.util.List;

public interface QuestionService {

    List<QuestionDTOResponse> getAllByForm(Integer id);

    List<QuestionDTOResponse> getAll();

}
