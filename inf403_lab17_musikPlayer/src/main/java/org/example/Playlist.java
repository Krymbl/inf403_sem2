package org.example;

import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Playlist {

    private List<Track> playlist = new ArrayList<>();
    private File file = new File("Playlist.pst");
    private PlaySound playSound;

    public Playlist() {}

    public void save() {
        try(ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("Playlist.pst"))){

            oos.writeObject(playlist);
            oos.flush();

        } catch(IOException e) {
            throw new RuntimeException();
        }
    }

    public void load() {
        if (!file.exists() || file.length() == 0) {
            playlist = new ArrayList<>();
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(file))) {
            playlist = (List<Track>) ois.readObject();
        } catch (FileNotFoundException e) {
            playlist = new ArrayList<>();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void add(Track track) {
        if (!check(track)) {
            return;
        }
        track.setNumber(playlist.size() + 1);
        playlist.add(track);
        System.out.println("Добавлен трек: " + track);
        save();

    }

    public void delete(int number) {
        if (number < 0 || number > getSize()) {
            System.out.println("Нет трека с таким номером");
            return;
        }
       Track trackDelete = findByNumber(number);
       playlist.remove(trackDelete.getNumber() - 1);
       if (number != getSize()) {
           int x = number;
           while (x <= getSize()) {
               Track next = findByNumber(x + 1);
               next.setNumber(x);
               x++;
           }
       }
       System.out.println("Удален трек: " + trackDelete);
       save();
    }
    public void showAll() {
        if (playlist.size() == 0) {
            System.out.println("Плейлист пустой");
        } else {
            for(Track track : playlist) {
                System.out.println(track);
            }
        }
    }

    public void findByName(String name) {
        playlist.stream()
                .filter(p -> p.getName().toUpperCase().contains(name.toUpperCase()))
                .forEach(track -> System.out.println(track));
    }

    public void findByAuthor(String author) {
        playlist.stream()
                .filter(p -> p.getAuthor().toUpperCase().contains(author.toUpperCase()))
                .forEach(track -> System.out.println(track));
    }

    public Track findByNumber(Integer number) {
        return
        playlist.stream()
                .filter(track -> track.getNumber().equals(number))
                .findFirst()
                .get();
    }

    public void clear () {
        playlist = new ArrayList<>();
        save();
    }

    public int getSize() {
        return playlist.size();
    }

    public boolean check(Track track) {
        PlaySound playSound = new PlaySound();
        try {
            playSound.play(track);
            playSound.stop();
        } catch (Exception e) {
            System.out.println("Файл WAV отсутсвует или удален");
            return false;
        }
        return true;
    }




}
