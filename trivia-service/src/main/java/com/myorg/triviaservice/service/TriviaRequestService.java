package com.myorg.triviaservice.service;

import com.myorg.triviaservice.configuration.Configuration;
import lombok.AllArgsConstructor;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TriviaRequestService {
    private final OkHttpClient client = new OkHttpClient();
    private Configuration configuration;
    public Call makeTriviaCall() {
        Request request = new Request.Builder()
                .url(configuration.getUrl())
                .build();

        return client.newCall(request);
    }
}
