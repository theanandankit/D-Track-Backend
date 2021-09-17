package com.atlan.formService.Service;

import com.atlan.formService.Models.Form;

import java.util.List;

public interface FormService {

    List<Form> getAll();

    Form get(Integer id);

    Form add(Form form);

}
