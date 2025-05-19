package org.chucknorris.project.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SpeakJokeServiceTest {
    @Test
    void speakJoke() throws IOException {
        AudioPlayService audioPlayService = new AudioPlayService();
        ChuckNorrisjokesService chuckNorrisjokesService = new ChuckNorrisjokesService();
        VoiceRssService voiceRssService = new VoiceRssService(audioPlayService);
        SpeakJokeService speakJokeService = new SpeakJokeService(chuckNorrisjokesService, voiceRssService);

        boolean spoken = speakJokeService.speakJoke();

        Assertions.assertTrue(spoken, "not spoken");

    }

}
