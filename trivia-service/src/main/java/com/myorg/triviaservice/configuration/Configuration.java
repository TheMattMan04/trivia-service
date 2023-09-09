package com.myorg.triviaservice.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties("trivia-service")
@RefreshScope
@Data
public class Configuration {
    private String url;
    private String environment;
    private Map<String, String> application;
}
