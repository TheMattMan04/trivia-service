package com.myorg.triviaservice.service;

import com.myorg.triviaservice.configuration.Configuration;
import com.myorg.triviaservice.model.Trivia;
import com.myorg.triviaservice.model.TriviaQuestions;
import lombok.AllArgsConstructor;
import okhttp3.Call;
import okhttp3.Response;
import org.json.JSONArray;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class TriviaService {
    private Configuration configuration;
    private TriviaRequestService triviaRequestService;

    public TriviaQuestions getTriviaQuestions() {
        TriviaQuestions triviaQuestions = new TriviaQuestions();
        List<Trivia> triviaList = new ArrayList<>();
        String environment = configuration.getEnvironment();

        Call triviaCall = triviaRequestService.makeTriviaCall();

        try {
            Response response = triviaCall.execute();

            String responseBody = response.body().string();

            JSONArray triviaQuestionsArray = new JSONArray(responseBody);

            triviaQuestionsArray
                    .toList()
                    .stream()
                    .map(triviaQuestion -> setTriviaQuestions(triviaQuestion, triviaList))
                    .toList();

            triviaQuestions.setEnvironment(environment);
            triviaQuestions.setResponseMessage("Success");
            triviaQuestions.setTriviaQuestions(triviaList);

        } catch (IOException e) {
            triviaQuestions.setEnvironment(environment);
            triviaQuestions.setResponseMessage("Error: " + e.getMessage());
            triviaQuestions.setTriviaQuestions(triviaList);
        }

        return triviaQuestions;
    }

    List<Trivia> setTriviaQuestions(Object triviaQuestion, List<Trivia> triviaList) {
        Trivia trivia = new Trivia();

        Map<String, String> triviaMap = (HashMap<String, String>) triviaQuestion;

        String category = triviaMap.get("category");
        String question = triviaMap.get("question");
        String correctAnswer = triviaMap.get("correctAnswer");
        Object incorrectAnswers = triviaMap.get("incorrectAnswers");

        trivia.setCategory(category);
        trivia.setQuestion(question);
        trivia.setCorrectAnswer(correctAnswer);

        List<Object> incorrectAnswerList = List.of(incorrectAnswers);

        trivia.setIncorrectAnswers(incorrectAnswerList);
        triviaList.add(trivia);

        return triviaList;
    }
}
