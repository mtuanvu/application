package com.fai.study.application.dto.request.user;

import com.fai.study.application.dto.request.profile.ProfileRequest;
import lombok.*;

@Data
public class UserRequest {
    private String email;
    private String phoneNumber;
    private String password;
    private ProfileRequest profile;
}
