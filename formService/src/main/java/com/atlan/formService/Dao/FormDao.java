package com.atlan.formService.Dao;

import com.atlan.formService.Models.Form;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormDao extends JpaRepository<Form, Integer> {
}
