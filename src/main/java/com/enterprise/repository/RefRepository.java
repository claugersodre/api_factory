package com.enterprise.repository;

import com.enterprise.entities.apiEntity.Ref;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefRepository extends JpaRepository<Ref,Long> {
}
