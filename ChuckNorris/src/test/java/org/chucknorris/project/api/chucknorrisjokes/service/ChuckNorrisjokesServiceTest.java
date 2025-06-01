package org.chucknorris.project.api.chucknorrisjokes.service;

import org.chucknorris.project.api.chucknorrisjokes.ChuckNorrisApiResponse;
import org.chucknorris.project.service.ChuckNorrisjokesService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;


class ChuckNorrisjokesServiceTest {

    @Test
    void run() throws IOException {
        ChuckNorrisjokesService chuckNorrisjokesService = new ChuckNorrisjokesService();

        String url = "https://api.chucknorris.io/jokes/random";
        String response = chuckNorrisjokesService.getResponse(url);

        Assertions.assertNotNull(response, "response is null");
    }

    @Test
    void convert() {
        ChuckNorrisjokesService chuckNorrisjokesService = new ChuckNorrisjokesService();

        ChuckNorrisApiResponse chuckNorrisApiResponse= chuckNorrisjokesService.convert("{\n" +
                "\"icon_url\" : \"https://api.chucknorris.io/img/avatar/chuck-norris.png\",\n" +
                "\"id\" : \"EtjJ5NqsTLa0RpRNMBH1aw\",\n" +
                "\"url\" : \"\",\n" +
                "\"value\" : \"Chuck Norris can hit a bull in the butt with a banjo.\"\n" +
                "}");

        Assertions.assertNotNull(chuckNorrisApiResponse, "response is null");
    }

    @Test
    void randomJoke() {
        ChuckNorrisjokesService chuckNorrisjokesService = new ChuckNorrisjokesService();

        ChuckNorrisApiResponse chuckNorrisApiResponse = chuckNorrisjokesService.randomJoke();

        Assertions.assertNotNull(chuckNorrisApiResponse, "response is null");


    }
}
