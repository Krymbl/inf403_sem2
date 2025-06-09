package org.example;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class PlaySound {
    private static Clip clip;
    private static Thread thread = new Thread();

    public Clip getClip() {
        return clip;
    }

    public static void play(Track track) {
         thread = new Thread(() -> {
                try {
                    AudioInputStream audioStream =
                            AudioSystem.getAudioInputStream(new File(track.getPath())); // Создание аудиопотока из файла
                    clip = AudioSystem.getClip(); //Создает аудиоклип для воспроизведения:
                    clip.open(audioStream);   //Открытие клипа с аудиопотоком
                    clip.start(); //Воспроизведение аудиоклипа
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            thread.start();
    }

    public static void stop() {
        clip.stop();
    }
}