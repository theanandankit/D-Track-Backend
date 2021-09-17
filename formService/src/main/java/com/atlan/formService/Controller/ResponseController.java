package com.atlan.formService.Controller;

import com.atlan.formService.Models.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ResponseController {

    ResponseEntity<List<Response>> getResponseByQuestion(Integer id);

    ResponseEntity<Response> add(Response response);

}
