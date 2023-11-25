package com.example.core.helpers.errorHandler;

import com.example.core.dto.ResponseErrorData;
import com.example.core.helpers.errorHandler.exceptions.MainException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandlerController {

    @ExceptionHandler(MainException.class)
    public ResponseEntity<ResponseErrorData> notFoundException(MainException exception) {
        return ResponseEntity
                .status(exception.getCode())
                .body(new ResponseErrorData(exception.getMessage(), exception.getCode()));
    }

}
