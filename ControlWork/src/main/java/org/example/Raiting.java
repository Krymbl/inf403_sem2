package org.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Raiting implements Serializable {
    List<Game> games = new ArrayList<>();
}

class Game implements Serializable, Comparable<Game> {
    String gamer;
    Integer raiting;
    Date gameDate;

    public Game(String gamer, Integer raiting, Date gameDate) {
        this.gamer = gamer;
        this.raiting = raiting;
        this.gameDate = gameDate;
    }

    @Override
    public int compareTo(Game other) {
        return other.raiting.compareTo(this.raiting);
    }
}