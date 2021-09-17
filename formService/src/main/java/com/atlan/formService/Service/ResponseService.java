package com.atlan.formService.Service;

import com.atlan.formService.Models.Question;
import com.atlan.formService.Models.Response;

import java.util.List;

public interface ResponseService {

    List<Response> getByQuestion(Question question);

    Response add(Response response);
}
