package com.fai.study.application.service.impl.user;

import com.fai.study.application.dto.request.user.UserRequest;
import com.fai.study.application.dto.response.user.UserResponse;
import com.fai.study.application.entities.User;
import com.fai.study.application.mapper.UserMapper;
import com.fai.study.application.repository.UserRepository;
import com.fai.study.application.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponse createUser(UserRequest request) {
        User user = userMapper.toUser(request);
        return userMapper.toUserResponse(userRepository.save(user));
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.getAllUsers().stream()
                .map(userMapper::toUserResponse)
                .toList();
    }

    @Override
    public UserResponse updateUser(UUID id, UserRequest request) {
        User user = userRepository.findUserById(id).orElseThrow(
                () -> new RuntimeException("Not found!")
        );

        userMapper.updateUser(user, request);
        return userMapper.toUserResponse(userRepository.save(user));
    }

    @Override
    public UserResponse getUserById(UUID id) {
        User user = userRepository.findUserById(id).orElseThrow(
                () -> new RuntimeException("Not found!")
        );

        return userMapper.toUserResponse(user);
    }

    @Override
    public void deleteUser(UUID id) {
        User user = userRepository.findUserById(id).orElseThrow(
                () -> new RuntimeException("Not found!")
        );

        userRepository.delete(user);
    }
}
