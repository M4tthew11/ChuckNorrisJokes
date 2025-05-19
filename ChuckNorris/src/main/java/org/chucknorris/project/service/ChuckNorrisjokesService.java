package org.chucknorris.project.service;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.chucknorris.project.api.chucknorrisjokes.ChuckNorrisApiResponse;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChuckNorrisjokesService {
    private static final String HTTPS_API_CHUCKNORRIS_IO_JOKES_RANDOM = "https://api.chucknorris.io/jokes/random";
    private static final Logger LOGGER = Logger.getLogger(ChuckNorrisjokesService.class.getName());

    private OkHttpClient client = new OkHttpClient();

    public ChuckNorrisApiResponse randomJoke(){
        LOGGER.info("randomJoke");
        try {
            String responseBody = getResponse(HTTPS_API_CHUCKNORRIS_IO_JOKES_RANDOM);
            ChuckNorrisApiResponse chuckNorrisApiResponse = convert(responseBody);
            LOGGER.info("randomJoke"+ responseBody);
            return chuckNorrisApiResponse;
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Unable to connect with api", e);
        }
        LOGGER.info("randomJoke"+ null);
        return null;
    }

    public String getResponse(String url) throws IOException {
        LOGGER.info("run("+url+")");
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            String body = response.body().string();
            LOGGER.info("run"+body);
            return body;
        }
    }
    public ChuckNorrisApiResponse convert(String body){
        LOGGER.info("convert("+ body);
        Gson gson = new Gson();
        ChuckNorrisApiResponse chuckNorrisApiResponse = gson.fromJson(body, ChuckNorrisApiResponse.class);
        LOGGER.info(""+chuckNorrisApiResponse);
        return chuckNorrisApiResponse;
    }
}
