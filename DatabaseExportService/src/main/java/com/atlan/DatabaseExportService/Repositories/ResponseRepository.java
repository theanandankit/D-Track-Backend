package com.atlan.DatabaseExportService.Repositories;

import com.atlan.DatabaseExportService.Models.Response;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResponseRepository extends JpaRepository<Response, Integer> {

    List<Response> getAllByQuestion(Integer id);
}
