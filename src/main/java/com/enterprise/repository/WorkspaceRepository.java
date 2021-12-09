package com.enterprise.repository;


import com.enterprise.entities.enterprise.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkspaceRepository extends JpaRepository<Workspace,Long> {
}
