package com.atlan.formService.Dao;

import com.atlan.formService.Models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionDao extends JpaRepository<Question, Integer> {
}
