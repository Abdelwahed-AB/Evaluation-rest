package com.evaluationrest.evaluationrest.services;

import com.evaluationrest.evaluationrest.entities.User;
import com.evaluationrest.evaluationrest.exceptions.UserNotFoundException;
import com.evaluationrest.evaluationrest.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService{

    private final UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(()->new UserNotFoundException(id));
    }

    @Override
    public void createUser(User user) {
        user.setId(0L);
        userRepository.save(user);
    }

    @Override
    public void updateUser(Long id, User user) {
        user.setId(id);
        userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        User user = findById(id);
        userRepository.delete(user);
    }
}
