package com.atlan.FormLoadBalanceService.LoadBalancerController;

import com.atlan.FormLoadBalanceService.Models.DTO.FormDTO.FormDTORequest;
import com.atlan.FormLoadBalanceService.Models.DTO.FormDTO.FormDTOResponse;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface FormController {

    List<FormDTOResponse> getRedirect(HttpServletRequest request);

    FormDTOResponse getRedirectToById(HttpServletRequest request);

    FormDTOResponse postRedirect(FormDTORequest form, HttpServletRequest request);
}
