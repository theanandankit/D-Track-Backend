package com.atlan.formService.Controller;

import com.atlan.formService.Models.DTO.FormDTO.FormDTORequest;
import com.atlan.formService.Models.DTO.FormDTO.FormDTOResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FormController {

    ResponseEntity<List<FormDTOResponse>> getAll();

    ResponseEntity<FormDTOResponse> getById(Integer id);

    ResponseEntity<FormDTOResponse> add(FormDTORequest formDTORequest);
}
