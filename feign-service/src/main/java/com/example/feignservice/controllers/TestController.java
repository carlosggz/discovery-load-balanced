package com.example.feignservice.controllers;

import com.example.feignservice.clients.SampleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/feign")
@RequiredArgsConstructor
@Slf4j
public class TestController {

    private final SampleService service;

    @GetMapping
    public String get() {
        log.info("Entered into the controller");
        return "Result: " + service.getValue();
    }
}
