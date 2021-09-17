package com.atlan.formService.Controller.Impl;

import com.atlan.formService.Controller.FormController;
import com.atlan.formService.Models.Form;
import com.atlan.formService.Service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FormControllerImpl implements FormController {

    @Autowired
    private FormService service;

    @Override
    @GetMapping("/forms")
    public ResponseEntity<List<Form>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }

    @Override
    @GetMapping("/form/{id}")
    public ResponseEntity<Form> getById(@RequestParam("id") Integer id) {

        Form result = service.get(id);

        if (result == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok().body(result);
    }

    @Override
    @PostMapping("/form")
    public ResponseEntity<Form> add(@RequestBody Form form) {
        Form result = service.add(form);

        if (form == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok().body(result);
    }
}
