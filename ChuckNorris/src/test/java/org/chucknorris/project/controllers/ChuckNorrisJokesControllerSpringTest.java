package org.chucknorris.project.controllers;

import org.chucknorris.project.api.chucknorrisjokes.ChuckNorrisApiResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ChuckNorrisJokesControllerSpringTest {
    @Autowired
    private ChuckNorrisJokesController chuckNorrisJokesController;
    @Test
    void randomJoke() {
        ChuckNorrisApiResponse chuckNorrisApiResponse = chuckNorrisJokesController.randomJoke();
        Assertions.assertNotNull(chuckNorrisApiResponse);
    }
}
