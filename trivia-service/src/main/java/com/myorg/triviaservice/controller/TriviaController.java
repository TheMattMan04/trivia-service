package com.myorg.triviaservice.controller;

import com.myorg.triviaservice.model.TriviaQuestions;
import com.myorg.triviaservice.service.TriviaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@Slf4j
@AllArgsConstructor
public class TriviaController {
    private TriviaService triviaService;
    @GetMapping("/api/trivia")
    public TriviaQuestions getAllTriviaQuestions() {
        return triviaService.getTriviaQuestions();
    }
}
