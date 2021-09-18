package com.atlan.formService.Service;

import com.atlan.formService.Models.DTO.FormDTO.FormDTORequest;
import com.atlan.formService.Models.DTO.FormDTO.FormDTOResponse;
import com.atlan.formService.Models.Form;

import java.util.List;

public interface FormService {

    List<FormDTOResponse> getAll();

    FormDTOResponse get(Integer id);

    FormDTOResponse add(FormDTORequest formDTORequest);

}
