package com.fai.study.application.mapper;

import com.fai.study.application.dto.request.profile.ProfileRequest;
import com.fai.study.application.dto.response.profile.ProfileResponse;
import com.fai.study.application.entities.Profile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProfileMapper {
    Profile toProfile(ProfileRequest request);

    @Mapping(target = "id", ignore = true)
    void updateProfile(@MappingTarget Profile profile, ProfileRequest request);

    ProfileResponse toProfileResponse(Profile profile);
}
