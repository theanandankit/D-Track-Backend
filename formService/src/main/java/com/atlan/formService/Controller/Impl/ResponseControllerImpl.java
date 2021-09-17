package com.atlan.formService.Controller.Impl;

import com.atlan.formService.Controller.ResponseController;
import com.atlan.formService.Models.Response;
import com.atlan.formService.Service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ResponseControllerImpl implements ResponseController {

    @Autowired
    private ResponseService service;

    @Override
    @GetMapping("/response")
    public ResponseEntity<List<Response>> getResponseByQuestion(@RequestParam(value = "question", required = false) Integer id) {

        List<Response> list = service.getByQuestion(id);

        if (list == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok().body(list);
    }

    @Override
    @PostMapping("/response")
    public ResponseEntity<Response> add(Response response) {

        Response result = service.add(response);

        if (result == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok().body(result);
    }
}
