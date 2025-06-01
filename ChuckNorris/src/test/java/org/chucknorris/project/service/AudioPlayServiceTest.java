package org.chucknorris.project.service;

import org.junit.jupiter.api.Test;

import java.io.InputStream;

class AudioPlayServiceTest {

    @Test
    void play() {
        AudioPlayService audioPlayService = new AudioPlayService();

        InputStream resourceAsStream = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("hello-joke.wav");

        audioPlayService.play(resourceAsStream);
    }
}
