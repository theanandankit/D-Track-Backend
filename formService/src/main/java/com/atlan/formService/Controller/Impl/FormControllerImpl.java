package com.atlan.formService.Controller.Impl;

import com.atlan.formService.Controller.FormController;
import com.atlan.formService.Models.DTO.ErrorDTO.ErrorDTORequest;
import com.atlan.formService.Models.DTO.FormDTO.FormDTORequest;
import com.atlan.formService.Models.DTO.FormDTO.FormDTOResponse;
import com.atlan.formService.Service.Impl.FormServiceImpl;
import com.atlan.formService.Service.SendError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.AsyncRestTemplate;

import java.util.List;

@RestController
public class FormControllerImpl implements FormController {

    @Autowired
    private FormServiceImpl service;

    @Autowired
    private SendError sendError;

    @Override
    @GetMapping("/forms")
    public ResponseEntity<List<FormDTOResponse>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }

    @Override
    @GetMapping("/form/{id}")
    public ResponseEntity<FormDTOResponse> getById(@PathVariable("id") Integer id) {

        System.out.println(id);
        FormDTOResponse result = service.get(id);

        if (result == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok().body(result);
    }

    @Override
    @PostMapping(value = "/form")
    public ResponseEntity<FormDTOResponse> add(@RequestBody FormDTORequest formDTORequest) {
        FormDTOResponse result = service.add(formDTORequest);

        if (result == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok().body(result);
    }
}
