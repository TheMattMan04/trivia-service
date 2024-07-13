package com.myorg.triviaservice.controller;

import com.myorg.triviaservice.model.Trivia;
import com.myorg.triviaservice.model.TriviaQuestions;
import com.myorg.triviaservice.service.TriviaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("trivia")
public class TriviaController {
    private final TriviaService triviaService;
    
    @GetMapping("/questions")
    public ResponseEntity<TriviaQuestions> getTriviaQuestions() {
        return ResponseEntity.ok(triviaService.getTriviaQuestions());
    }

    @GetMapping("/question")
    public ResponseEntity<Trivia> getTriviaQuestion() {
        return ResponseEntity.ok(triviaService.getTriviaQuestion());
    }

}
