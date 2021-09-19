package com.atlan.FormLoadBalanceService.LoadBalancerController.Impl;

import com.atlan.FormLoadBalanceService.LoadBalancerController.QuestionController;
import com.atlan.FormLoadBalanceService.Models.DTO.QuestionDTO.QuestionDTORequest;
import com.atlan.FormLoadBalanceService.Models.DTO.QuestionDTO.QuestionDTOResponse;
import com.atlan.FormLoadBalanceService.Utils.Values;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@RestController
public class QuestionControllerImpl implements QuestionController {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    @GetMapping("/question")
    public List<QuestionDTOResponse> getRedirectToByForm(HttpServletRequest request) {
        String formId = request.getParameter("form");
        QuestionDTOResponse[] questions = restTemplate.getForObject(Values.FORM_URL + request.getRequestURI() + "?form=" + formId, QuestionDTOResponse[].class);
        return Arrays.asList(questions);
    }

    @Override
    @PostMapping("/question")
    public QuestionDTOResponse postRedirect(HttpServletRequest request, QuestionDTORequest question) {
        return restTemplate.postForObject(Values.FORM_URL + request.getRequestURI(), question, QuestionDTOResponse.class);
    }
}
