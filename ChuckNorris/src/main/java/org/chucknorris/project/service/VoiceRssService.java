package org.chucknorris.project.service;

import okhttp3.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class VoiceRssService {
    private static final String HTTPS_API_CHUCKNORRIS_IO_JOKES_RANDOM = "http://api.voicerss.org/?key=d1f948cf1e9c4dd5a8da3fb3a36071c8&hl=en-us&src=Hello, world!";
    private static final Logger LOGGER = Logger.getLogger(VoiceRssService.class.getName());

    private OkHttpClient client;

    private final AudioPlayService audioPlayService;

    public VoiceRssService(AudioPlayService audioPlayService) {
        this.client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();

        this.audioPlayService = audioPlayService;
    }


    public boolean speakJoke(String textToVoice) throws IOException {
        LOGGER.info("speakJoke"+ textToVoice);
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host("api.voicerss.org")
                .addQueryParameter("key","d1f948cf1e9c4dd5a8da3fb3a36071c8")
                .addQueryParameter("hl","en-us")
                .addQueryParameter("src",textToVoice)
                .build();
        Request request = new Request.Builder().url(httpUrl).build();

        try (Response response = client.newCall(request).execute()) {
            LOGGER.info("response"+response);
            if (response != null){
                ResponseBody responseBody = response.body();
                if (responseBody != null){
                    InputStream inputStream = new ByteArrayInputStream(responseBody.bytes());
                    if (inputStream != null) {
                        audioPlayService.play(inputStream);
                        LOGGER.info("Speak joke[...]"+ true);
                        return true;
                    }
                }
            }
        }
        LOGGER.info("Speak joke[...]"+ false);
        return false;
    }
}
