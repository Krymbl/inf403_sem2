package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Playlist {

    private List<Track> playlist;

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
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("Playlist.pst"))) {
            playlist = (List<Track>) ois.readObject();
        } catch (FileNotFoundException e) {
            playlist = new ArrayList<>();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public void add(Track track) {
        track.setNumber(playlist.size() + 1);
        playlist.add(track);
        save();

    }
    public void showAll() {
        for(Track track : playlist) {
            System.out.println(track.getNumber() + ": " +
                    track.getName() + ", " +
                    track.getAuthor());
        }
    }

    public void findByName(String name) {
        playlist.stream()
                .filter(p -> p.getName().toUpperCase().contains(name.toUpperCase()))
                .forEach(track -> System.out.println(track.getNumber() + ": " +
                        track.getName() + ", " +
                        track.getAuthor()));
    }

    public void findByAuthor(String author) {
        playlist.stream()
                .filter(p -> p.getName().toUpperCase().contains(author.toUpperCase()))
                .forEach(track -> System.out.println(track.getNumber() + ": " +
                        track.getName() + ", " +
                        track.getAuthor()));
    }

    public Optional<Track> findByNumber(Integer number) {
        return
        playlist.stream()
                .filter(track -> track.getNumber().equals(number))
                .findFirst();
    }
}
