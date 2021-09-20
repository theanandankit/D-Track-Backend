package com.atlan.ErrorDataService.Repositories;

import com.atlan.ErrorDataService.Models.Error;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ErrorRepository extends JpaRepository<Error, Integer> {
}
