package com.atlan.formService.Dao;

import com.atlan.formService.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
}
