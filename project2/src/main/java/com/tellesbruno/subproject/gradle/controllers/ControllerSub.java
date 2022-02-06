package com.tellesbruno.subproject.gradle.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping
public class ControllerSub {
    @GetMapping
    public String subproject() {
        return "Esta é uma sub-aplicação!";
    }

    @GetMapping("/requestparam")
    public String requestID(@RequestParam(defaultValue = "0") Integer id) {
        return "ID recebido: " + id;
    }

    @GetMapping("/optionalparam")
    public String optionalID(@RequestParam(name = "id", required = false) Integer optid) {
        return "ID recebido: " + optid;
    }

    @GetMapping("usingoptional")
    public String usingOptional(@RequestParam Optional<Integer> id) {
        return "ID recebido: " + id.orElse(null);
    }

}
