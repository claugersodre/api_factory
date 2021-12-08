package com.enterprise.repository;

import com.enterprise.entities.apiEntity.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiRepository extends JpaRepository<Api,Long> {
}
