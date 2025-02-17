package com.fai.study.application.dto.response.profile;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfileResponse {
    private String id;
    private String fullName;
    private String dob;
    private String gender;
    private String avatar;
    private String bio;
}
