package com.atlan.DatabaseExportService.Repositories;

import com.atlan.DatabaseExportService.Models.Form;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormRepository extends JpaRepository<Form, Integer> {
}
