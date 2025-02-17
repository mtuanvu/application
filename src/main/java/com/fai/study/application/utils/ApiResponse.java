package com.fai.study.application.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Builder;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class ApiResponse<T> {
    private int code;
    private String error;
    private T data;

    public ApiResponse(int code, String error, T data) {
        this.code = code;
        this.error = error;
        this.data = data;
    }

    public ApiResponse() {
    }
}
