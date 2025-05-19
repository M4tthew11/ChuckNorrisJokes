package org.chucknorris.project;

import org.chucknorris.project.controllers.VoiceRssController;
import org.chucknorris.project.service.AudioPlayService;
import org.chucknorris.project.service.VoiceRssService;

import java.io.IOException;

public class VoiceRssApplication {
    public static void main(String[] args) throws IOException {
        AudioPlayService audioPlayService = new AudioPlayService();
        VoiceRssService voiceRssService = new VoiceRssService(audioPlayService);
        VoiceRssController voiceRssController = new VoiceRssController(voiceRssService);

        boolean play = voiceRssController.play("Hello Joke!");

    }
}
