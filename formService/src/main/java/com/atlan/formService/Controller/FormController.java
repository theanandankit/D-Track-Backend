package com.atlan.formService.Controller;

import com.atlan.formService.Models.Form;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FormController {

    ResponseEntity<List<Form>> getAll();

    ResponseEntity<Form> getById(Integer id);

    ResponseEntity<Form> add(Form form);

}
