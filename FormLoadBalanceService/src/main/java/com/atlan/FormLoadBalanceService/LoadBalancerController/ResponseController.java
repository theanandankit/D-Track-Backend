package com.atlan.FormLoadBalanceService.LoadBalancerController;

import com.atlan.FormLoadBalanceService.Models.DTO.ResponseDTO.ResponseDTORequest;
import com.atlan.FormLoadBalanceService.Models.DTO.ResponseDTO.ResponseDTOResponse;

import javax.servlet.http.HttpServletRequest;

public interface ResponseController {

    ResponseDTOResponse getRedirectToByQuestion(HttpServletRequest request);

    ResponseDTOResponse postRedirect(HttpServletRequest request, ResponseDTORequest response);
}
