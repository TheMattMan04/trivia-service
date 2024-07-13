package com.myorg.triviaservice.service;

import com.myorg.triviaservice.feign.TriviaQuestionsClient;
import com.myorg.triviaservice.mapper.TriviaQuestionMapper;
import com.myorg.triviaservice.model.Trivia;
import com.myorg.triviaservice.model.TriviaClientResponse;
import com.myorg.triviaservice.model.TriviaQuestions;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class TriviaService {
    private final TriviaQuestionsClient triviaQuestionsClient;
    private final TriviaQuestionMapper triviaQuestionMapper = TriviaQuestionMapper.INSTANCE;
    private final Random random = new Random();

    public TriviaQuestions getTriviaQuestions() {
        log.debug("Fetching trivia questions....");

        List<TriviaClientResponse> triviaClientResponse = triviaQuestionsClient.getTriviaQuestions();
        
        List<Trivia> triviaQuestionList = triviaClientResponse
                .stream()
                .map(triviaQuestionMapper::mapToTrivia)
                .toList();

        return TriviaQuestions
                .builder()
                .triviaQuestions(triviaQuestionList)
                .build();
    }

    public Trivia getTriviaQuestion() {
        log.debug("Fetching trivia question....");

        List<TriviaClientResponse> triviaClientResponse = triviaQuestionsClient.getTriviaQuestions();

        List<Trivia> triviaQuestionList  = triviaClientResponse
                .stream()
                .map(triviaQuestionMapper::mapToTrivia)
                .toList();

        return triviaQuestionList.get(random.nextInt(triviaQuestionList.size()));
    }
}
