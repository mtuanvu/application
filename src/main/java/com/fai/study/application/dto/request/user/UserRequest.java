package com.fai.study.application.dto.request.user;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {
    private String email;
    private String phoneNumber;
    private String password;
}
