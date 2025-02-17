package com.fai.study.application.mapper;

import com.fai.study.application.dto.request.user.UserRequest;
import com.fai.study.application.dto.request.user.UserUpdate;
import com.fai.study.application.dto.response.user.UserResponse;
import com.fai.study.application.entities.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", uses = ProfileMapper.class)
public interface UserMapper {
    User toUser(UserRequest request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUser(@MappingTarget User user, UserUpdate request);


    UserResponse toUserResponse(User user);
}
