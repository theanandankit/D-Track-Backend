package com.atlan.FormLoadBalanceService.LoadBalancerController;

import com.atlan.FormLoadBalanceService.Models.DTO.ResponseDTO.ResponseDTORequest;
import com.atlan.FormLoadBalanceService.Models.DTO.ResponseDTO.ResponseDTOResponse;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

public interface ResponseController {

    ResponseEntity<ResponseDTOResponse> getRedirectToByQuestion(HttpServletRequest request);

    ResponseEntity<ResponseDTOResponse> postRedirect(HttpServletRequest request, ResponseDTORequest response);
}
