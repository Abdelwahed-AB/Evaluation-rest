package com.evaluationrest.evaluationrest.repositories;

import com.evaluationrest.evaluationrest.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
