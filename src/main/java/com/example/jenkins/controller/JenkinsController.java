package com.example.jenkins.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jenkins")
public class JenkinsController {

    @GetMapping("/send")
    public String send(String param) {
        param = "jenkins:" + param;
        return param;
    }
}
