package com.myorg.triviaservice.model;

import java.util.List;

public record Trivia(
        String category,
        String question,
        String correctAnswer,
        List<String> incorrectAnswers
) {
}
