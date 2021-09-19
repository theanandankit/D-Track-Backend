package com.atlan.DatabaseExportService.Repositories;

import com.atlan.DatabaseExportService.Models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

    List<Question> getAllByForm(Integer id);
}
