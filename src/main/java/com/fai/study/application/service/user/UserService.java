package com.fai.study.application.service.user;

import com.fai.study.application.dto.request.user.UserRequest;
import com.fai.study.application.dto.request.user.UserUpdate;
import com.fai.study.application.dto.response.user.UserResponse;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserResponse createUser(UserRequest request);
    List<UserResponse> getAllUsers();
    UserResponse updateUser(UUID id, UserUpdate request);
    UserResponse getUserById(UUID id);
    void deleteUser(UUID id);
}
