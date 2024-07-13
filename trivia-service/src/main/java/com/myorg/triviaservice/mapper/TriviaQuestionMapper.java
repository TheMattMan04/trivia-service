package com.myorg.triviaservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.myorg.triviaservice.model.Trivia;
import com.myorg.triviaservice.model.TriviaClientResponse;

@Mapper(componentModel = "spring")
public interface TriviaQuestionMapper {
     TriviaQuestionMapper INSTANCE = Mappers.getMapper(TriviaQuestionMapper.class);

     @Mapping(source = "category", target = "category")
     @Mapping(source = "question", target = "question")
     @Mapping(source = "correctAnswer", target = "correctAnswer")
     @Mapping(source = "incorrectAnswers", target = "incorrectAnswers")
     Trivia mapToTrivia(TriviaClientResponse triviaClientResponse);
}
