package org.example;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Maze maze = new Maze();

        Scanner scanner = new Scanner(System.in);
        CheckPoint<Maze> checkPoint = new CheckPoint("GameSaves.txt");

        System.out.println("Во время игры вы можете сделать чекпоинт и загрузить игру с этого момента. \n1.Сделать чекпоинт. \n2.Загрузить чекпоинт. \nНажмите на 'Y' чтобы продолжить.");
        while (!scanner.nextLine().toUpperCase().equals("Y")) {
            System.out.println("Нажмите на 'Y' чтобы продолжить.");
        }
        Visual.getVisual(maze.getX(), maze.getY(), maze.getMas());
        
        while (true) {
            System.out.println("Сделайте ход");
            String move = scanner.nextLine();
            if (move.equals("1")) {
                checkPoint.save(maze);
            } if (move.equals("2")) {
                maze = checkPoint.load();
            }
            maze.action(move);
            Visual.getVisual(maze.getX(), maze.getY(), maze.getMas());
            if (Maze.check(maze.getX(), maze.getY())) {
                System.out.println("Финал!");
                break;
            }

        }
    }
}