package com.atlan.FormLoadBalanceService.LoadBalancerController;

import com.atlan.FormLoadBalanceService.Models.DTO.QuestionDTO.QuestionDTORequest;
import com.atlan.FormLoadBalanceService.Models.DTO.QuestionDTO.QuestionDTOResponse;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface QuestionController {

    List<QuestionDTOResponse> getRedirectToByForm(HttpServletRequest request);

    QuestionDTOResponse postRedirect(HttpServletRequest request, QuestionDTORequest question);

}
