package com.fai.study.application.utils;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse <T> {
    private int code;
    private String message;
    private T data;
}
