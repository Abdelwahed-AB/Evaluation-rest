package com.evaluationrest.evaluationrest.mappers;

import com.evaluationrest.evaluationrest.dto.request.UserRequest;
import com.evaluationrest.evaluationrest.dto.response.UserResponse;
import com.evaluationrest.evaluationrest.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements IUserMapper{
    @Override
    public User userRequestToUser(UserRequest userRequest) {
        User user = User.builder()
                .username(userRequest.username())
                .build();
        return user;
    }

    @Override
    public UserResponse userToUserResponse(User user) {
        UserResponse userResponse = new UserResponse(
                user.getId(),
                user.getUsername()
        );
        return userResponse;
    }
}
