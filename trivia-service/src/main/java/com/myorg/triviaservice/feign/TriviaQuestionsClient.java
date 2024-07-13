package com.myorg.triviaservice.feign;

import com.myorg.triviaservice.model.TriviaClientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "triviaQuestionsClient", url = "https://the-trivia-api.com/api/questions") //TODO: read this from application.yml
public interface TriviaQuestionsClient {

    @GetMapping
    List<TriviaClientResponse> getTriviaQuestions();
    
}