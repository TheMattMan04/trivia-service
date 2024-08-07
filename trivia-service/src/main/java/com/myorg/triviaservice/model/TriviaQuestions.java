package com.myorg.triviaservice.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class TriviaQuestions {
    
    private List<Trivia> triviaQuestions;
}
