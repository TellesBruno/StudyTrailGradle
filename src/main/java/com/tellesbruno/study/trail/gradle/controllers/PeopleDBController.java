package com.tellesbruno.study.trail.gradle.controllers;


import com.tellesbruno.study.trail.gradle.models.LoginToken;
import com.tellesbruno.study.trail.gradle.models.PeopleDB;
import com.tellesbruno.study.trail.gradle.models.PeopleDBModel;
import com.tellesbruno.study.trail.gradle.service.AuthService;
import com.tellesbruno.study.trail.gradle.service.PeopleDBService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Api(value = "Persistence API")
@RequestMapping("/persistence")
    public class PeopleDBController {

    PeopleDBService peopleDBService;
    AuthService authService;

    @ApiOperation(value = "Get all people from the database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})
    @GetMapping("/people-db")
    public List<PeopleDB> getAllPeopleDB(){
        return peopleDBService.getAllPeopleDB();
    }

    @ApiOperation(value = "Get people with specific id from the database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})
    @GetMapping("/people-db/{id}")
    public PeopleDB getPeopleDB(@PathVariable(value = "id") int id){
        return peopleDBService.getPeopleDB(id);
    }

    @ApiOperation(value = "Delete people with specific id from the database")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Successfully deleted, nothing to return"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})
    @DeleteMapping("/people-db/{id}")
    public ResponseEntity<PeopleDB> deletePeopleDB(@PathVariable("id") int id){
        return peopleDBService.deletePeopleDB(id);
    }

    @ApiOperation(value = "Add new people to the database")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created successfully"),
            @ApiResponse(code = 400, message = "Bad Request")})
    @PostMapping("/people-db")
    public ResponseEntity<PeopleDB> addPeopleDB(@RequestBody PeopleDBModel people){
        return peopleDBService.addPeopleDB(people);
    }

    @ApiOperation(value = "Edit people with specific id from the database")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Successfully edited"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})
    @PutMapping("/people-db/{id}")
    public ResponseEntity<PeopleDB> updatePeopleDB(@PathVariable("id") int id, @RequestBody PeopleDBModel people){
        return peopleDBService.updatePeopleDB(id, people);
    }

    @ApiOperation(value = "Login with username and password")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully logged in"),
            @ApiResponse(code = 401, message = "Unauthorized")})
    @PostMapping("/auth/login")
    public ResponseEntity<String> login(@RequestBody LoginToken loginToken){
        return authService.login(loginToken);
    }
}
