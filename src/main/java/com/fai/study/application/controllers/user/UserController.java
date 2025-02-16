package com.fai.study.application.controllers.user;

import com.fai.study.application.dto.request.user.UserRequest;
import com.fai.study.application.dto.response.user.UserResponse;
import com.fai.study.application.service.impl.user.UserServiceImpl;
import com.fai.study.application.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userService;

    @PostMapping
    public ApiResponse<UserResponse> createUser(@RequestBody UserRequest request) {
        UserResponse user = userService.createUser(request);
        return ApiResponse.<UserResponse>builder()
                .code(200)
                .data(user)
                .build();
    }

    @GetMapping
    public ApiResponse<List<UserResponse>> getUsers() {
        List<UserResponse> allUsers = userService.getAllUsers();
        return ApiResponse.<List<UserResponse>>builder()
                .code(200)
                .data(allUsers)
                .build();
    }

    @PutMapping("/{id}")
    public ApiResponse<UserResponse> updateUser(@PathVariable UUID id, @RequestBody UserRequest request) {
        UserResponse userResponse = userService.updateUser(id, request);
        return ApiResponse.<UserResponse>builder()
                .code(200)
                .data(userResponse)
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<UserResponse> getUserById(@PathVariable UUID id) {
        UserResponse userById = userService.getUserById(id);
        return ApiResponse.<UserResponse>builder()
                .code(200)
                .data(userById)
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteUser(@PathVariable UUID id) {
        userService.deleteUser(id);

        ApiResponse<String> response = new ApiResponse<>();
        response.setCode(200);
        response.setMessage("User deleted successfully");

        return ResponseEntity.status(203).body(response);
    }
}
