package org.example;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class PlaySound {
    private Clip clip;

    public Clip getClip() {
        return clip;
    }

    public void play(Track track) {
        new Thread(()->{try {
            AudioInputStream audioStream =
                    AudioSystem.getAudioInputStream(new File(track.getPath()));
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
            //clip.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }}).start();


    }
}