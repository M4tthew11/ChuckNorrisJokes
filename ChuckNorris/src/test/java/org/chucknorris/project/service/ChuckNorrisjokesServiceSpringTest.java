package org.chucknorris.project.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ChuckNorrisjokesServiceSpringTest {

    @Autowired
    private ChuckNorrisjokesService service;
    @Test
    void randomJoke() throws IOException {
        String url = "https://api.chucknorris.io/jokes/random";
        String response = service.getResponse(url);
        Assertions.assertNotNull(response, "response is null");
    }

}
