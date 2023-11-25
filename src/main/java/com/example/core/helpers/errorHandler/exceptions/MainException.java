package com.example.core.helpers.errorHandler.exceptions;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MainException extends RuntimeException {

    private String message;
    private Integer code;

    public MainException(String message, Integer code) {
        super(message);
        this.message = message;
        this.code = code;
    }
}
