package com.fai.study.application.controllers.user;

import com.fai.study.application.dto.request.user.UserRequest;
import com.fai.study.application.dto.request.user.UserUpdate;
import com.fai.study.application.dto.response.user.UserResponse;
import com.fai.study.application.service.impl.user.UserServiceImpl;
import com.fai.study.application.utils.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping
    public ApiResponse<UserResponse> createUser(@RequestBody UserRequest request) {
        return new ApiResponse<>(200, "Success", userService.createUser(request));
    }

    @GetMapping
    public ApiResponse<List<UserResponse>> getUsers() {
        return new ApiResponse<>(200, "Success", userService.getAllUsers());
    }

    @PutMapping("/{id}")
    public ApiResponse<UserResponse> updateUser(@PathVariable UUID id, @RequestBody UserUpdate request) {
        return new ApiResponse<>(200, "Success", userService.updateUser(id, request));
    }

    @GetMapping("/{id}")
    public ApiResponse<UserResponse> getUserById(@PathVariable UUID id) {
        return new ApiResponse<>(200, "Success", userService.getUserById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable UUID id) {
        userService.deleteUser(id);


        return ResponseEntity.status(203).body("Delete Success");
    }
}
