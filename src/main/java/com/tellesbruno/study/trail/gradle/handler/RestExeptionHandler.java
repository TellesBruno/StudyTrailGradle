package com.tellesbruno.study.trail.gradle.handler;



import com.tellesbruno.study.trail.gradle.errors.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import java.util.Date;

@RestControllerAdvice
public class RestExeptionHandler extends DefaultHandlerExceptionResolver {
    @ExceptionHandler(HttpRequestExeption.class)
    public ResponseEntity<?> HandleHttpRequestError(HttpRequestExeption exception) {
        HttpExeptionCustom hreCuston = HttpExeptionCustom.builder()
                .title(exception.getTitle())
                .statusCode(exception.getStatusCode())
                .detail(exception.getMessage())
                .timestamp(new Date().getTime())
                .developerMessage("O heandler de erro foi chamado")
                .build();

        return new ResponseEntity<>(hreCuston, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<?> HttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException exception) {
        HttpExeptionCustom hreCuston = HttpExeptionCustom.builder()
                .title("Method not supported")
                .statusCode(HttpStatus.METHOD_NOT_ALLOWED.value())
                .detail(exception.getMessage())
                .timestamp(new Date().getTime())
                .developerMessage("O heandler de erro foi chamado")
                .build();

        return new ResponseEntity<>(hreCuston, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<?> HttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException exception) {
        HttpExeptionCustom hreCuston = HttpExeptionCustom.builder()
                .title("Media type not supported")
                .statusCode(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value())
                .detail(exception.getMessage())
                .timestamp(new Date().getTime())
                .developerMessage("O heandler de erro foi chamado")
                .build();

        return new ResponseEntity<>(hreCuston, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> MethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException exception) {
        HttpExeptionCustom hreCuston = HttpExeptionCustom.builder()
                .title("Method argument type mismatch")
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .detail(exception.getMessage())
                .timestamp(new Date().getTime())
                .developerMessage("O heandler de erro foi chamado")
                .build();

        return new ResponseEntity<>(hreCuston, HttpStatus.BAD_REQUEST);
    }


}
