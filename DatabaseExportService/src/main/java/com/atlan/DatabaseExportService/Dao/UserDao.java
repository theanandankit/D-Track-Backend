package com.atlan.DatabaseExportService.Dao;

import com.atlan.DatabaseExportService.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
}
