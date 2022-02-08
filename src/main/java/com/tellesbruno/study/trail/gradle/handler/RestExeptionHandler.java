package com.tellesbruno.study.trail.gradle.handler;



import com.tellesbruno.study.trail.gradle.errors.BadRequestExeption;
import com.tellesbruno.study.trail.gradle.errors.HttpExeptionCustom;
import com.tellesbruno.study.trail.gradle.errors.InternalServerExeption;
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
        HttpExeptionCustom nfCuston = HttpExeptionCustom.builder()
                .title("Not Found")
                .statusCode(HttpStatus.NOT_FOUND.value())
                .detail(exeption.getMessage())
                .timestamp(new Date().getTime())
                .developerMessage("O heandler de erro foi chamado")
                .build();

        return new ResponseEntity<>(nfCuston, HttpStatus.NOT_FOUND);
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

    @ExceptionHandler(InternalServerExeption.class)
    public ResponseEntity<?> handleInternalServerError(InternalServerExeption exeption) {
        HttpExeptionCustom iseCuston = HttpExeptionCustom.builder()
                .title("Internal Server Error")
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .detail(exeption.getMessage())
                .timestamp(new Date().getTime())
                .developerMessage("O heandler de erro foi chamado")
                .build();

        return new ResponseEntity<>(iseCuston, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
