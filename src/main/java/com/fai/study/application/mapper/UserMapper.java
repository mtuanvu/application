package com.fai.study.application.mapper;

import com.fai.study.application.dto.request.user.UserRequest;
import com.fai.study.application.dto.response.user.UserResponse;
import com.fai.study.application.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserRequest request);

    @Mapping(target = "id", ignore = true)
    void updateUser(@MappingTarget User user, UserRequest request);

    UserResponse toUserResponse(User user);
}
