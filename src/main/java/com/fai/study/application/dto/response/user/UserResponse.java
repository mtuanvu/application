package com.fai.study.application.dto.response.user;

import com.fai.study.application.dto.response.profile.ProfileResponse;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private String id;
    private String email;
    private String phoneNumber;
    private ProfileResponse profile;
}
