package com.tellesbruno.study.trail.gradle.service;

import com.tellesbruno.study.trail.gradle.errors.HttpRequestExeption;
import com.tellesbruno.study.trail.gradle.models.LoginToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    public ResponseEntity<?> login(LoginToken loginToken) {
        String myUser = "User";
        String myPassword = "Password";

        if (loginToken.getUser().equals(myUser) && loginToken.getPassword().equals(myPassword)) {
            return ResponseEntity.ok("Login Successful");
        } else {
            throw new HttpRequestExeption(
                    "Unautoorized",
                    "Wrong user name or password",
                    HttpStatus.UNAUTHORIZED.value());
        }
    }
}