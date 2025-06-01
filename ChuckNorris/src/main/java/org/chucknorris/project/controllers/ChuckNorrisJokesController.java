package org.chucknorris.project.controllers;

import org.chucknorris.project.api.chucknorrisjokes.ChuckNorrisApiResponse;
import org.chucknorris.project.service.ChuckNorrisjokesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/jokes")
public class ChuckNorrisJokesController {
    private static final Logger LOGGER = Logger.getLogger(ChuckNorrisJokesController.class.getName());
    private final ChuckNorrisjokesService chuckNorrisJokesService;

    public ChuckNorrisJokesController(ChuckNorrisjokesService chuckNorrisjokesService) {
        this.chuckNorrisJokesService = chuckNorrisjokesService;
    }

    @GetMapping
    public String jokeView(){
        LOGGER.info("Joke view");
        return "jokes.html";
    }
    @PostMapping
    public String joke(ModelMap model){
        LOGGER.info("Joke");
        ChuckNorrisApiResponse chuckNorrisApiResponse = randomJoke();
        model.addAttribute("joke", chuckNorrisApiResponse.getValue());
        LOGGER.info("Joke"+ chuckNorrisApiResponse.getValue());
        return "jokes.html";
    }

    public ChuckNorrisApiResponse randomJoke(){
        LOGGER.info("randomJoke");
        ChuckNorrisApiResponse chuckNorrisApiResponse = chuckNorrisJokesService.randomJoke();
        LOGGER.info("randomJoke"+ chuckNorrisApiResponse);

        return chuckNorrisApiResponse;
    }
}
