package org.chucknorris.project.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class VoiceRssServiceTest {

    @Test
    void speakJoke() throws IOException {
        AudioPlayService audioPlayService = new AudioPlayService();
        VoiceRssService voiceRssService = new VoiceRssService(audioPlayService);

        boolean spoken = voiceRssService.speakJoke("Hello Joke!");

        Assertions.assertTrue(spoken, "not spoken");
    }
}
