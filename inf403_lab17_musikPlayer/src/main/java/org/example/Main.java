package org.example;

public class Main {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        playlist.load();
        playlist.add(new Track( "Ночь", "Mayot", "C:\\Users\\dasts\\Downloads\\MAYOT_-_noch_76470274.wav" ));
        playlist.save();

        Console console = new Console();
        console.startCommand();
    }
}