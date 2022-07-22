package com.myorg.triviaservice.model;

import lombok.Data;

import java.util.List;

@Data
public class TriviaQuestions {

    private String responseMessage;
    private List<Trivia> triviaQuestions;
}
