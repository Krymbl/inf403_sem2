package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Playlist {

    private List<Track> playlist = new ArrayList<>();
    private File file = new File("Playlist.pst");

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

    public  void load() {
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
        track.setNumber(playlist.size() + 1);
        playlist.add(track);
        save();

    }
    public void showAll() {
        if (playlist.size() == 0) {
            System.out.println("Плейлист пустой");
        } else {
        for(Track track : playlist) {
            System.out.println(track.getNumber() + ": " +
                    track.getName() + " - " +
                    track.getAuthor());
        }
        }
    }

    public void findByName(String name) {
        playlist.stream()
                .filter(p -> p.getName().toUpperCase().contains(name.toUpperCase()))
                .forEach(track -> System.out.println(track.getNumber() + ": " +
                        track.getName() + " - " +
                        track.getAuthor()));
    }

    public void findByAuthor(String author) {
        playlist.stream()
                .filter(p -> p.getAuthor().toUpperCase().contains(author.toUpperCase()))
                .forEach(track -> System.out.println(track.getNumber() + ": " +
                        track.getName() + " - " +
                        track.getAuthor()));
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
}
