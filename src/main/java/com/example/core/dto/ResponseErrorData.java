package com.example.core.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseErrorData {

    private String message;
    private Integer code;

    public ResponseErrorData(String message, Integer code) {
        this.message = message;
        this.code = code;
    }
}
