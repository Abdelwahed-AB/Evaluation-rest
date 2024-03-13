package com.evaluationrest.evaluationrest.repositories;

import com.evaluationrest.evaluationrest.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
