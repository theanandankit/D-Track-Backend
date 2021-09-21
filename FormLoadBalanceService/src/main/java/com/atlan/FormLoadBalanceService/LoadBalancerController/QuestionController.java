package com.atlan.FormLoadBalanceService.LoadBalancerController;

import com.atlan.FormLoadBalanceService.Models.DTO.QuestionDTO.QuestionDTORequest;
import com.atlan.FormLoadBalanceService.Models.DTO.QuestionDTO.QuestionDTOResponse;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface QuestionController {

    ResponseEntity<List<QuestionDTOResponse>> getRedirectToByForm(HttpServletRequest request);

    ResponseEntity<QuestionDTOResponse> postRedirect(HttpServletRequest request, QuestionDTORequest question);

}
