package com.atlan.FormLoadBalanceService.LoadBalancerController;

import com.atlan.FormLoadBalanceService.Models.DTO.FormDTO.FormDTORequest;
import com.atlan.FormLoadBalanceService.Models.DTO.FormDTO.FormDTOResponse;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface FormController {

    ResponseEntity<List<FormDTOResponse>> getRedirect(HttpServletRequest request);

    ResponseEntity<FormDTOResponse> getRedirectToById(HttpServletRequest request);

    ResponseEntity<FormDTOResponse> postRedirect(FormDTORequest form, HttpServletRequest request);
}
