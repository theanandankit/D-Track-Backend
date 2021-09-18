package com.atlan.formService.Controller.Impl;

import com.atlan.formService.Controller.ResponseController;
import com.atlan.formService.Models.DTO.ResponseDTO.ResponseDTORequest;
import com.atlan.formService.Models.DTO.ResponseDTO.ResponseDTOResponse;
import com.atlan.formService.Models.Response;
import com.atlan.formService.Service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ResponseControllerImpl implements ResponseController {

    @Autowired
    private ResponseService service;

    @Override
    @GetMapping("/responses")
    public ResponseEntity<List<ResponseDTOResponse>> getResponseByQuestion(@RequestParam(value = "question", required = false) Integer id) {

        List<ResponseDTOResponse> list = service.getByQuestion(id);

        if (list == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok().body(list);
    }

    @Override
    @PostMapping("/response")
    public ResponseEntity<ResponseDTOResponse> add(@RequestBody ResponseDTORequest response) {

        ResponseDTOResponse result = service.add(response);

        if (result == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok().body(result);
    }
}
