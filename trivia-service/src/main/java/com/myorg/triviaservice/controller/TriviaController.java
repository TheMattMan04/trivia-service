package com.myorg.triviaservice.controller;

import com.myorg.triviaservice.service.TriviaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TriviaController {

    @Autowired
    private TriviaService triviaService;

    @GetMapping("/api/trivia")
    public String getUrl() {
        return triviaService.getUrl();
    }
}
