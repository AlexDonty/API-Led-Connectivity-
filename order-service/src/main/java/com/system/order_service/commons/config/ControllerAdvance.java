package com.system.order_service.commons.config;

import com.system.order_service.commons.dtos.ResponseErrorDto;
import com.system.order_service.commons.exception.NotFountExceptio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvance {

    @ExceptionHandler(NotFountExceptio.class)
    public ResponseEntity<ResponseErrorDto> badRequestMethod(NotFountExceptio e){
        return new ResponseEntity<>(ResponseErrorDto.builder()
                .message(e.getMessage())
                .build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseErrorDto> badRequestMethodValidator (MethodArgumentNotValidException e){
        return new ResponseEntity<>(ResponseErrorDto.builder()
                .message(e.getMessage())
                .build(), HttpStatus.BAD_REQUEST);
    }
}
