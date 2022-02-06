package com.tellesbruno.subproject.gradle.handler;


import com.tellesbruno.subproject.gradle.errors.BadRequestCuston;
import com.tellesbruno.subproject.gradle.errors.BadRequestExeption;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class RestExeptionHandler {
    @ExceptionHandler(BadRequestExeption.class)
    public ResponseEntity<?> handleBadRequest(BadRequestExeption exeption) {

        BadRequestCuston brCuston = BadRequestCuston.builder()
                .title("Bad Request")
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .detail(exeption.getMessage())
                .timestamp(new Date().getTime())
                .developerMessage("O heandler de erro foi chamado")
                .build();

        return new ResponseEntity<>(brCuston, HttpStatus.BAD_REQUEST);
    }

}
