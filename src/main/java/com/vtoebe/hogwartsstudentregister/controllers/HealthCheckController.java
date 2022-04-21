package com.vtoebe.hogwartsstudentregister.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @GetMapping("/health-check")
    public String heathCheck(){ return "Server is running!"; }
}
