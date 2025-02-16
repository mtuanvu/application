package com.fai.study.application.service.profile;

import com.fai.study.application.dto.request.profile.ProfileRequest;
import com.fai.study.application.dto.response.profile.ProfileResponse;

import java.util.List;
import java.util.UUID;

public interface ProfileService {
    ProfileResponse createProfile(ProfileRequest request);
    List<ProfileResponse> getAllProfiles();
    ProfileResponse updateProfile(UUID id, ProfileRequest request);
    ProfileResponse getProfileById(UUID id);
    void deleteProfile(UUID id);
}
