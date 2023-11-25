package com.example.core.helpers.errorHandler;

import com.example.core.dto.ResponseErrorMessage;
import com.example.core.helpers.errorHandler.exceptions.MainException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandlerController {

    @ExceptionHandler(MainException.class)
    public ResponseEntity<ResponseErrorMessage> notFoundException(MainException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ResponseErrorMessage(exception.getMessage(), exception.getCode()));
    }

}
