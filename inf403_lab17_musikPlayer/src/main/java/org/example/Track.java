package org.example;

import java.io.Serializable;

public class Track implements Serializable {
    private Integer number;
    private String name;
    private String author;
    private String path;

    public Track(){}

    public Track(String name, String author, String path) {
        this.name = name;
        this.author = author;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return number + ": " + name + " - " + author;
    }
}
