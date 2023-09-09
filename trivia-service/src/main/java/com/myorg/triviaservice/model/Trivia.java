package com.myorg.triviaservice.model;

import lombok.Data;

import java.util.List;

@Data
public class Trivia {
    private String category;
    private String question;
    private String correctAnswer;
    private List<Object> incorrectAnswers;
}
