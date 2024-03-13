package com.evaluationrest.evaluationrest.mappers;

import com.evaluationrest.evaluationrest.dto.request.UserRequest;
import com.evaluationrest.evaluationrest.dto.response.UserResponse;
import com.evaluationrest.evaluationrest.entities.User;

public interface IUserMapper {
    User userRequestToUser(UserRequest userRequest);
    UserResponse userToUserResponse(User user);
}
