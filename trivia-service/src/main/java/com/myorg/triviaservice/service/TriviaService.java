package com.myorg.triviaservice.service;

import com.myorg.triviaservice.configuration.Configuration;
import com.myorg.triviaservice.model.Trivia;
import com.myorg.triviaservice.model.TriviaQuestions;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class TriviaService {

    @Autowired
    private Configuration configuration;
    private final OkHttpClient client = new OkHttpClient();

    public TriviaQuestions getTriviaQuestions() {
        TriviaQuestions triviaQuestions = new TriviaQuestions();
        List<Trivia> triviaList = new ArrayList<>();

        Request request = new Request.Builder()
                .url(configuration.getUrl())
                .build();

        Call call = client.newCall(request);

        try {
            Response response = call.execute();

            String responseBody = response.body().string();

            JSONArray triviaQuestionsArray = new JSONArray(responseBody);

            triviaQuestionsArray.forEach(triviaQuestion -> {
                Trivia trivia = new Trivia();

                String triviaString = triviaQuestion.toString();

                JSONObject triviaJson = new JSONObject(triviaString);

                String category = triviaJson.getString("category");
                String question = triviaJson.getString("question");
                String correctAnswer = triviaJson.getString("correctAnswer");
                JSONArray incorrectAnswers = triviaJson.getJSONArray("incorrectAnswers");

                trivia.setCategory(category);
                trivia.setQuestion(question);
                trivia.setCorrectAnswer(correctAnswer);

                List<String> incorrectAnswerList = new ArrayList<>();

                incorrectAnswers.forEach(incorrect -> {
                    incorrectAnswerList.add(incorrect.toString());
                });

                trivia.setIncorrectAnswers(incorrectAnswerList);

                triviaList.add(trivia);
            });

            triviaQuestions.setResponseMessage("Success");
            triviaQuestions.setTriviaQuestions(triviaList);

        } catch (IOException e) {
            triviaQuestions.setResponseMessage("Error: " + e.getMessage());
            triviaQuestions.setTriviaQuestions(triviaList);
        }

        return triviaQuestions;
    }

}
