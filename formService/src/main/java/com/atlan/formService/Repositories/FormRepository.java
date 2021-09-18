package com.atlan.formService.Repositories;

import com.atlan.formService.Models.Form;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormRepository extends JpaRepository<Form, Integer> {
}
