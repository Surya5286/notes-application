package com.secure.notes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHi() {
        return "hello";
    }

    @GetMapping("/demo/hello")
    public String sayHello() {
        return "hello";
    }
}
