package org.chucknorris.project.controllers;

import org.chucknorris.project.api.chucknorrisjokes.ChuckNorrisApiResponse;
import org.chucknorris.project.service.ChuckNorrisjokesService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChuckNorrisJokesControllerTest {

    @Test
    void randomJoke() {
        ChuckNorrisjokesService chuckNorrisjokesService = new ChuckNorrisjokesService();
        ChuckNorrisJokesController chuckNorrisJokesController = new ChuckNorrisJokesController(chuckNorrisjokesService);

        ChuckNorrisApiResponse chuckNorrisApiResponse = chuckNorrisJokesController.randomJoke();

        Assertions.assertNotNull(chuckNorrisApiResponse,"responmse is null");


    }
}
