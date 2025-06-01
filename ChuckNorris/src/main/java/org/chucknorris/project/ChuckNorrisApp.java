package org.chucknorris.project;

import org.chucknorris.project.api.chucknorrisjokes.ChuckNorrisApiResponse;
import org.chucknorris.project.controllers.ChuckNorrisJokesController;
import org.chucknorris.project.service.ChuckNorrisjokesService;

public class ChuckNorrisApp {
    public static void main(String[] args) {
        ChuckNorrisjokesService chuckNorrisjokesService = new ChuckNorrisjokesService();
        ChuckNorrisJokesController chuckNorrisJokesController = new ChuckNorrisJokesController(chuckNorrisjokesService);

        ChuckNorrisApiResponse chuckNorrisApiResponse = chuckNorrisJokesController.randomJoke();

        String joke = chuckNorrisApiResponse.getValue();

    }
}
