package com.awesome.typing1.domain.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }
}
