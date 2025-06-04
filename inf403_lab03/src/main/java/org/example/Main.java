package org.example;

public class Main {
    public static void main(String[] args) {
        Auto mine = new Auto("Lada", "Largus", 2010, 100);
        Auto another = new Auto("Lada", "Largus", 2011, 105);
        System.out.println(mine.equals(another));
    }
}