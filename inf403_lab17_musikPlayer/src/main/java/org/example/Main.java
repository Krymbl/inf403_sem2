package org.example;

public class Main {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        playlist.load();
        playlist.add(new Track( "Black eyes", "Chaikovskiy", null ));
        playlist.save();
    }
}