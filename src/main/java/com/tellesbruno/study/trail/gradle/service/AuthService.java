package com.tellesbruno.study.trail.gradle.service;

import com.tellesbruno.study.trail.gradle.errors.HttpRequestExeption;
import com.tellesbruno.study.trail.gradle.models.LoginToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    public ResponseEntity<String> login(LoginToken loginToken) {
        var myUser = "User";
        var myPassword = "Password";

        if (loginToken.getUser().equals(myUser) && loginToken.getPassword().equals(myPassword)) {
            return ResponseEntity.ok("Login Successful");
        } else {
            throw new HttpRequestExeption(
                    "Unauthorized",
                    "Wrong user name or password",
                    HttpStatus.UNAUTHORIZED);
        }
    }
}
