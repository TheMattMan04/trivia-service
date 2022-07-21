package com.myorg.triviaservice.service;

import com.myorg.triviaservice.configuration.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TriviaService {

    @Autowired
    private Configuration configuration;

    public String getUrl() {
        return configuration.getUrl();
    }

}
