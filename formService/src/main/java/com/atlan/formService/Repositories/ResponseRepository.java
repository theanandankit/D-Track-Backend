package com.atlan.formService.Repositories;

import com.atlan.formService.Models.Response;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResponseRepository extends JpaRepository<Response, Integer> {

    List<Response> getAllByQuestion(Integer integer);
}
