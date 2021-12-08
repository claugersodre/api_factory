package com.enterprise.repository;

import com.enterprise.entities.apiEntity.Parameters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParametersRepository extends JpaRepository<Parameters,Long> {
}
