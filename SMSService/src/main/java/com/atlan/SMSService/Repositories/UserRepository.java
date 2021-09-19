package com.atlan.SMSService.Repositories;

import com.atlan.SMSService.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
