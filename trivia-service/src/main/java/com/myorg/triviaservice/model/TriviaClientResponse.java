package com.myorg.triviaservice.model;

import java.util.List;

public record TriviaClientResponse(
        String category,
        String correctAnswer,
        String difficulty,
        String id,
        List<String> incorrectAnswers,
        boolean isNiche,
        String question,
        List<String> regions,
        List<String> tags,
        String type
) {
}




