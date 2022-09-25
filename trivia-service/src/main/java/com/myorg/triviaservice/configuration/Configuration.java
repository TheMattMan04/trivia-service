package com.myorg.triviaservice.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("trivia-service")
@RefreshScope
@Data
public class Configuration {

    private String url;
    private String environment;
}
