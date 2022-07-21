package com.myorg.triviaservice.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("trivia-service")
@Data
public class Configuration {

    private String url;
}
