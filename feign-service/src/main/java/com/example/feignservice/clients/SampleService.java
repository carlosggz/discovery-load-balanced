package com.example.feignservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "sample-service")
public interface SampleService {

    @GetMapping("/api/test")
    String getValue();
}
