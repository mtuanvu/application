package com.fai.study.application.dto.request.profile;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfileRequest {
    private String fullName;
    private String dob;
    private String gender;
    private String avatar;
    private String bio;
}
