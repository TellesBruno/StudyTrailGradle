package com.tellesbruno.study.trail.gradle.handler;



import com.tellesbruno.study.trail.gradle.errors.BadRequestExeption;
import com.tellesbruno.study.trail.gradle.errors.HttpExeptionCustom;
import com.tellesbruno.study.trail.gradle.errors.NotFoundExeption;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class RestExeptionHandler {
    @ExceptionHandler(NotFoundExeption.class)
    public ResponseEntity<?> handleNotFound(NotFoundExeption exeption) {
        HttpExeptionCustom brCuston = HttpExeptionCustom.builder()
                .title("Not Found")
                .statusCode(HttpStatus.NOT_FOUND.value())
                .detail(exeption.getMessage())
                .timestamp(new Date().getTime())
                .developerMessage("O heandler de erro foi chamado")
                .build();

        return new ResponseEntity<>(brCuston, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestExeption.class)
    public ResponseEntity<?> handleBadRequest(BadRequestExeption exeption) {
        HttpExeptionCustom brCuston = HttpExeptionCustom.builder()
                .title("Bad Request")
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .detail(exeption.getMessage())
                .timestamp(new Date().getTime())
                .developerMessage("O heandler de erro foi chamado")
                .build();

        return new ResponseEntity<>(brCuston, HttpStatus.BAD_REQUEST);
    }

}
