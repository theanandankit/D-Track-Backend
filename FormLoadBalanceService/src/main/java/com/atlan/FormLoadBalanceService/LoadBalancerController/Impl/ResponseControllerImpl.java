package com.atlan.FormLoadBalanceService.LoadBalancerController.Impl;

import com.atlan.FormLoadBalanceService.LoadBalancerController.ResponseController;
import com.atlan.FormLoadBalanceService.Models.DTO.ResponseDTO.ResponseDTORequest;
import com.atlan.FormLoadBalanceService.Models.DTO.ResponseDTO.ResponseDTOResponse;
import com.atlan.FormLoadBalanceService.Utils.Values;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ResponseDTOResponse> getRedirectToByQuestion(HttpServletRequest request) {
        try {
            return ResponseEntity.ok().body(restTemplate.getForObject(Values.FORM_URL + request.getRequestURI(), ResponseDTOResponse.class));
        } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Override
    @PostMapping("/response")
    public ResponseEntity<ResponseDTOResponse> postRedirect(HttpServletRequest request, @RequestBody ResponseDTORequest response) {
        if (response.getValue().equals("my name is ankit")) {
            restTemplate.getForObject(Values.SMS_URL, void.class);
        }
        try {
            return ResponseEntity.ok().body(restTemplate.postForObject(Values.FORM_URL + request.getRequestURI(), response, ResponseDTOResponse.class));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
