package com.enterprise.repository;

import com.enterprise.entities.enterprise.UserApi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserApi,Long> {
}
