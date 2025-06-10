package org.example;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class PlaySound {
    private static Clip clip;

    public Clip getClip() {
        return clip;
    }

    public void play(Track track) {
            try {
                AudioInputStream audioStream =
                        AudioSystem.getAudioInputStream(new File(track.getPath())); // Создание аудиопотока из файла
                clip = AudioSystem.getClip(); //Создает аудиоклип для воспроизведения:
                clip.open(audioStream);   //Открытие клипа с аудиопотоком
                clip.start(); //Воспроизведение аудиоклипа
            } catch (Exception e) {
                throw new RuntimeException();
            }

        }

    public void stop() {
        clip.stop();
    }
}