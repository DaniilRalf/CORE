package com.example.core.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseErrorMessage {

    private String message;
    private Integer code;

    public ResponseErrorMessage(String message, Integer code) {
        this.message = message;
        this.code = code;
    }
}
