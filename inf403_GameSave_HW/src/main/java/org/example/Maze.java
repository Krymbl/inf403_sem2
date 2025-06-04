package org.example;

import java.io.Serializable;

public class Maze implements Serializable {
    private int mas[][] = {
        {1, 0, 1, 0, 1, 1, 1},
        {0, 0, 1, 0, 0, 0, 1},
        {1, 0, 0, 0, 1, 1, 1},
        {1, 0, 1, 1, 0, 0, 0},
        {1, 0, 0, 0, 0, 1, 0},
        {0, 0, 1, 0, 1, 0, 0},
        {1, 1, 1, 1, 1, 0, 1}
    };

    public int[][] getMas() {
        return mas;
    }

    private int x = 1;
    private int y = 0;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void action(String move) {

            if (move.equals("w") && (y > 0)) {
                if ((mas[y-1][x] == 1) || (mas[y-1][x] == 2)) {
                    System.out.println("Тупик");
                    mas[y-1][x] = 2;
                } else {
                    y--;
                }

            } else if (move.equals("s") && (y < mas.length)) {
                if ((mas[y+1][x] == 1) || (mas[y+1][x] == 2)) {
                    System.out.println("Тупик");
                    mas[y+1][x] = 2;
                } else {
                    y++;
                }

            } else if (move.equals("a") && (x > 0)) {
                if ((mas[y][x-1] == 1) || (mas[y][x-1] == 2)) {
                    System.out.println("Тупик");
                    mas[y][x-1] = 2;
                } else {
                    x--;
                }

            } else if (move.equals("d") && (x < mas[0].length)) {
                if ((mas[y][x+1] == 1) || (mas[y][x+1] == 2)) {
                    System.out.println("Тупик");
                    mas[y][x+1] = 2;
                } else {
                    x++;
                }
            } else {
                System.out.println ("Нельзя заходить за границы!");
            }
        }

    public static boolean check(int finalX, int finalY) {
        if ((finalX == 5) && (finalY == 6)) {
            return true;
        }
        return false;
    }
}