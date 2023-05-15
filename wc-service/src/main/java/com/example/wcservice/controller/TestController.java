package com.example.wcservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/wc")
@RequiredArgsConstructor
@Slf4j
public class TestController {

    private final WebClient.Builder wcBuilder;

    @GetMapping
    public Mono<String> get() {
        return wcBuilder
            .baseUrl("lb://sample-service")
            .build()
            .get()
            .uri("/api/test")
            .retrieve()
            .bodyToMono(String.class)
            .map(x -> "Result: " + x);
    }
}
