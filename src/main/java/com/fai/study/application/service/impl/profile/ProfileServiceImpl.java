package com.fai.study.application.service.impl.profile;

import com.fai.study.application.dto.request.profile.ProfileRequest;
import com.fai.study.application.dto.response.profile.ProfileResponse;
import com.fai.study.application.entities.Profile;
import com.fai.study.application.mapper.ProfileMapper;
import com.fai.study.application.repository.ProfileRepository;
import com.fai.study.application.service.profile.ProfileService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProfileServiceImpl implements ProfileService {
    private final ProfileRepository profileRepository;
    private final ProfileMapper profileMapper;

    public ProfileServiceImpl(ProfileRepository profileRepository, ProfileMapper profileMapper) {
        this.profileRepository = profileRepository;
        this.profileMapper = profileMapper;
    }

    @Override
    public List<ProfileResponse> getAllProfiles() {
        return profileRepository.getAllProfiles().stream()
                .map(profileMapper::toProfileResponse)
                .toList();
    }

    @Override
    public ProfileResponse updateProfile(UUID id, ProfileRequest request) {
        Profile profile = profileRepository.findProfileById(id)
                .orElseThrow(() -> new RuntimeException("Not found!"));

        profileMapper.updateProfile(profile, request);
        return profileMapper.toProfileResponse(profileRepository.save(profile));
    }

    @Override
    public ProfileResponse getProfileById(UUID id) {
        Profile profile = profileRepository.findProfileById(id).orElseThrow(
                () -> new RuntimeException("Not found!")
        );

        return profileMapper.toProfileResponse(profile);
    }
}
