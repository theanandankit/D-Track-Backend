package com.atlan.FormLoadBalanceService.LoadBalancerController.Impl;

import com.atlan.FormLoadBalanceService.LoadBalancerController.FormController;
import com.atlan.FormLoadBalanceService.Models.DTO.FormDTO.FormDTORequest;
import com.atlan.FormLoadBalanceService.Models.DTO.FormDTO.FormDTOResponse;
import com.atlan.FormLoadBalanceService.Utils.Values;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<FormDTOResponse> getRedirect(HttpServletRequest request) {
        FormDTOResponse[] forms =  restTemplate.getForObject(Values.FORM_URL + request.getRequestURI(), FormDTOResponse[].class);
        return Arrays.asList(forms);
    }

    @Override
    @GetMapping("/form/{id}")
    public FormDTOResponse getRedirectToById(HttpServletRequest request) {
        System.out.println(request.getRequestURI());
        return restTemplate.getForObject(Values.FORM_URL + request.getRequestURI(), FormDTOResponse.class);
    }

    @Override
    @PostMapping("/form")
    public FormDTOResponse postRedirect(@RequestBody FormDTORequest form, HttpServletRequest request) {
        return restTemplate.postForObject(Values.FORM_URL + request.getRequestURI(), form, FormDTOResponse.class);
    }
}
