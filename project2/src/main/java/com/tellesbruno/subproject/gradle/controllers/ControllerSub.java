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
    public String requestID(@RequestParam(defaultValue = "default") String id) {
        return "ID recebido: " + id;
    }

    @GetMapping("/optionalparam")
    public String optionalID(@RequestParam(name = "id", required = false) String optid) {
        return "ID recebido: " + optid;
    }

    @GetMapping("usingoptional")
    public String usingOptional(@RequestParam Optional<String> id) {
        return "ID recebido: " + id.orElse("Não foi recebido");
    }

}
