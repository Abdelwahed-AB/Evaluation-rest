package com.evaluationrest.evaluationrest.services;

import com.evaluationrest.evaluationrest.entities.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    User findById(Long id);
    void createUser(User user);
    void updateUser(Long id, User user);
    void deleteUserById(Long id);
}
