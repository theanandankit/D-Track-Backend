package com.atlan.FormLoadBalanceService.LoadBalancerController.Impl;

import com.atlan.FormLoadBalanceService.LoadBalancerController.FormController;
import com.atlan.FormLoadBalanceService.Models.DTO.FormDTO.FormDTORequest;
import com.atlan.FormLoadBalanceService.Models.DTO.FormDTO.FormDTOResponse;
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
import java.util.Arrays;
import java.util.List;

@RestController
public class FormControllerImpl implements FormController {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    @GetMapping("/forms")
    public ResponseEntity<List<FormDTOResponse>> getRedirect(HttpServletRequest request) {
        try {
            FormDTOResponse[] forms = restTemplate.getForObject(Values.FORM_URL + request.getRequestURI(), FormDTOResponse[].class);
            return ResponseEntity.ok().body(Arrays.asList(forms));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Override
    @GetMapping("/form/{id}")
    public ResponseEntity<FormDTOResponse> getRedirectToById(HttpServletRequest request) {
        try {
            return ResponseEntity.ok().body(restTemplate.getForObject(Values.FORM_URL + request.getRequestURI(), FormDTOResponse.class));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Override
    @PostMapping("/form")
    public ResponseEntity<FormDTOResponse> postRedirect(@RequestBody FormDTORequest form, HttpServletRequest request) {
        try {
            return ResponseEntity.ok().body(restTemplate.postForObject(Values.FORM_URL + request.getRequestURI(), form, FormDTOResponse.class));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
