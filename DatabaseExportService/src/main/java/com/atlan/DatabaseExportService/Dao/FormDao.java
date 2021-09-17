package com.atlan.DatabaseExportService.Dao;

import com.atlan.DatabaseExportService.Models.Form;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormDao extends JpaRepository<Form, Integer> {
}
