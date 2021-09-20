package com.atlan.formService.Service;

import com.atlan.formService.Models.DTO.ErrorDTO.ErrorDTORequest;

public interface SendError {

    void SendError(ErrorDTORequest errorDTO);
}
