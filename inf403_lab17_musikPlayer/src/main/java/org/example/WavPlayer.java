package org.example;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class WavPlayer {
    public static void main(String[] args) {
        try {
            AudioInputStream audioStream =
                    AudioSystem.getAudioInputStream(new File("C:\\Users\\dasts\\Downloads\\MAYOT_-_noch_76470274.wav")); // Создание аудиопотока из файла:
            Clip clip = AudioSystem.getClip(); //Создает аудиоклип для воспроизведения:
            clip.open(audioStream);  // Открытие клипа с аудиопотоком:
            clip.start(); // Запуск воспроизведения
            //clip.stop();

            //Программа ждет окончания трека, вычисляя его длительность
            //Thread.sleep() приостанавливает выполнение
            Thread.sleep(clip.getMicrosecondLength() / 1000); // Ждём окончания
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}