package service;

import com.myorg.triviaservice.feign.TriviaQuestionsClient;
import com.myorg.triviaservice.service.TriviaService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = TriviaService.class)
public class TriviaServiceTests {

    @Mock
    private TriviaService triviaService;

    @Mock
    private TriviaQuestionsClient triviaQuestionsClient;

    @Disabled
    @Test
    void testGetTriviaQuestions() {

    }
}
