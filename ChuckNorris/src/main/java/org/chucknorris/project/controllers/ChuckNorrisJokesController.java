package org.chucknorris.project.controllers;

import org.chucknorris.project.api.chucknorrisjokes.ChuckNorrisApiResponse;
import org.chucknorris.project.service.ChuckNorrisjokesService;

import java.util.logging.Logger;

public class ChuckNorrisJokesController {
    private static final Logger LOGGER = Logger.getLogger(ChuckNorrisJokesController.class.getName());
    private final ChuckNorrisjokesService chuckNorrisJokesService;

    public ChuckNorrisJokesController(ChuckNorrisjokesService chuckNorrisjokesService) {
        this.chuckNorrisJokesService = chuckNorrisjokesService;
    }

    public ChuckNorrisApiResponse randomJoke(){
        LOGGER.info("randomJoke");
        ChuckNorrisApiResponse chuckNorrisApiResponse = chuckNorrisJokesService.randomJoke();
        LOGGER.info("randomJoke"+ chuckNorrisApiResponse);

        return chuckNorrisApiResponse;
    }
}
