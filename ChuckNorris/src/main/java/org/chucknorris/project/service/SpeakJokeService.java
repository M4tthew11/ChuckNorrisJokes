package org.chucknorris.project.service;

import org.chucknorris.project.api.chucknorrisjokes.ChuckNorrisApiResponse;

import java.io.IOException;
import java.util.logging.Logger;

public class SpeakJokeService {
    private static final Logger LOGGER = Logger.getLogger(SpeakJokeService.class.getName());
    private final ChuckNorrisjokesService chuckNorrisjokesService;
    private final VoiceRssService voiceRssService;

    public SpeakJokeService(ChuckNorrisjokesService chuckNorrisjokesService, VoiceRssService voiceRssService) {

        this.chuckNorrisjokesService = chuckNorrisjokesService;
        this.voiceRssService = voiceRssService;
    }
    public boolean speakJoke() throws IOException {
        LOGGER.info("speakJoke");
        ChuckNorrisApiResponse chuckNorrisApiResponse = chuckNorrisjokesService.randomJoke();
        String joke = chuckNorrisApiResponse.getValue();

        boolean spoken = voiceRssService.speakJoke(joke);

        LOGGER.info("speakJoke" + spoken);
        return spoken;
    }
}
