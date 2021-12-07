package com.enterprise.repository;

import com.enterprise.entities.enterprise.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise,Long> {
}
