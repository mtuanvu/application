package com.fai.study.application.mapper;

import com.fai.study.application.dto.request.profile.ProfileRequest;
import com.fai.study.application.dto.response.profile.ProfileResponse;
import com.fai.study.application.entities.Profile;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ProfileMapper {
    @Mapping(target = "user", ignore = true)
    Profile toProfile(ProfileRequest request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateProfile(@MappingTarget Profile profile, ProfileRequest request);

    ProfileResponse toProfileResponse(Profile profile);
}
