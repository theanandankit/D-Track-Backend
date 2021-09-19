package com.atlan.FormLoadBalanceService.LoadBalancerController.Impl;

import com.atlan.FormLoadBalanceService.LoadBalancerController.ResponseController;
import com.atlan.FormLoadBalanceService.Models.DTO.ResponseDTO.ResponseDTORequest;
import com.atlan.FormLoadBalanceService.Models.DTO.ResponseDTO.ResponseDTOResponse;
import com.atlan.FormLoadBalanceService.Utils.Values;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ResponseControllerImpl implements ResponseController {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    @GetMapping("/response")
    public ResponseDTOResponse getRedirectToByQuestion(HttpServletRequest request) {
        return restTemplate.getForObject(Values.FORM_URL + request.getRequestURI(), ResponseDTOResponse.class);
    }

    @Override
    @PostMapping("/response")
    public ResponseDTOResponse postRedirect(HttpServletRequest request, @RequestBody ResponseDTORequest response) {
        if (response.getValue().equals("my name is ankit")) {
            restTemplate.getForObject(Values.SMS_URL, void.class);
        }
        return restTemplate.postForObject(Values.FORM_URL + request.getRequestURI(), response, ResponseDTOResponse.class);
    }
}
