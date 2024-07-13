package com.paneladev.hello.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {

    @Value("${app.name}")
    public String appName;

    @GetMapping
    public String HelloWorld() {
        return "Hello " + appName;
    }

}