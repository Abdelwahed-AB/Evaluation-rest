package com.evaluationrest.evaluationrest.controllers;

import com.evaluationrest.evaluationrest.dto.request.UserRequest;
import com.evaluationrest.evaluationrest.dto.response.UserResponse;
import com.evaluationrest.evaluationrest.entities.User;
import com.evaluationrest.evaluationrest.mappers.IUserMapper;
import com.evaluationrest.evaluationrest.services.IUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final IUserMapper userMapper;
    private final IUserService userService;

    @GetMapping
    public List<UserResponse> getAllUsers(){
        return userService.findAll().stream().map(userMapper::userToUserResponse).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable("id") Long id){
        return userMapper.userToUserResponse(userService.findById(id));
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody @Valid  UserRequest userRequest){
        User user = userMapper.userRequestToUser(userRequest);
        userService.createUser(user);

        return ResponseEntity.status(HttpStatus.CREATED).body("User created.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable("id") Long id, @RequestBody @Valid UserRequest userRequest){
        User user = userMapper.userRequestToUser(userRequest);
        userService.updateUser(id, user);

        return ResponseEntity.ok("User updated.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id){
        userService.deleteUserById(id);
        return ResponseEntity.ok("User deleted.");
    }
}
