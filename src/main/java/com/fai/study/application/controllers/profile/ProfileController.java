package com.fai.study.application.controllers.profile;

import com.fai.study.application.dto.request.profile.ProfileRequest;
import com.fai.study.application.dto.response.profile.ProfileResponse;
import com.fai.study.application.service.impl.profile.ProfileServiceImpl;
import com.fai.study.application.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/profiles")
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileServiceImpl profileService;

    @PostMapping
    public ApiResponse<ProfileResponse> createProfile(@RequestBody ProfileRequest request) {
        ProfileResponse profile = profileService.createProfile(request);
        return ApiResponse.<ProfileResponse>builder()
                .code(200)
                .data(profile)
                .build();
    }

    @GetMapping
    public ApiResponse<List<ProfileResponse>> getAllProfiles() {
        List<ProfileResponse> allProfiles = profileService.getAllProfiles();
        return ApiResponse.<List<ProfileResponse>>builder()
                .code(200)
                .data(allProfiles)
                .build();
    }

    @PutMapping("/{id}")
    public ApiResponse<ProfileResponse> updateProfile(@PathVariable UUID id, @RequestBody ProfileRequest request) {
        ProfileResponse profileResponse = profileService.updateProfile(id, request);
        return ApiResponse.<ProfileResponse>builder()
                .code(200)
                .data(profileResponse)
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<ProfileResponse> getProfile(@PathVariable UUID id) {
        ProfileResponse profileById = profileService.getProfileById(id);
        return ApiResponse.<ProfileResponse>builder()
                .code(200)
                .data(profileById)
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteProfile(@PathVariable UUID id) {
        profileService.deleteProfile(id);

        ApiResponse<String> response = new ApiResponse<>();
        response.setCode(200);
        response.setMessage("Profile deleted successfully");

        return ResponseEntity.status(203).body(response);
    }
}
