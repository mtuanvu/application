package com.fai.study.application.controllers.profile;

import com.fai.study.application.dto.request.profile.ProfileRequest;
import com.fai.study.application.dto.response.profile.ProfileResponse;
import com.fai.study.application.service.impl.profile.ProfileServiceImpl;
import com.fai.study.application.utils.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/profiles")
public class ProfileController {
    private final ProfileServiceImpl profileService;

    public ProfileController(ProfileServiceImpl profileService) {
        this.profileService = profileService;
    }

    @GetMapping
    public ApiResponse<List<ProfileResponse>> getAllProfiles() {
        return new ApiResponse<>(200, "Success" ,profileService.getAllProfiles());
    }

    @PutMapping("/{id}")
    public ApiResponse<ProfileResponse> updateProfile(@PathVariable UUID id, @RequestBody ProfileRequest request) {
       return new ApiResponse<>(200, "Success" ,profileService.updateProfile(id, request));
    }

    @GetMapping("/{id}")
    public ApiResponse<ProfileResponse> getProfile(@PathVariable UUID id) {
        return new ApiResponse<>(200, "Success", profileService.getProfileById(id));
    }

}
