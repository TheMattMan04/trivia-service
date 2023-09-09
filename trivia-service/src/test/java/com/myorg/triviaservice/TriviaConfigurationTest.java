package com.myorg.triviaservice;

import com.myorg.triviaservice.configuration.Configuration;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TriviaConfigurationTest {
    @Mock
    private Configuration configuration;

    @Test
    void testTriviaConfiguration() {
        Mockito.when(configuration.getEnvironment()).thenReturn("local");
    }

}
