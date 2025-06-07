package org.example;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;


public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static LoadAndSaves loadAndSaves = new LoadAndSaves();


    public static void main(String[] args) {

        try {
            Questions questions = loadAndSaves.loadQuestions();

            Raiting raiting = loadAndSaves.loadRaiting();
            if (raiting == null) {
                raiting = new Raiting();
            }

            playGame(questions, raiting);

            loadAndSaves.saveRaiting(raiting);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void playGame(Questions questions, Raiting raiting) {
        System.out.println("Добро пожаловать в блиц-опрос!");
        System.out.print("Введите ваше имя: ");
        String playerName = scanner.nextLine();

        int pointScore = 0;

        pointScore += askQuestion(questions.question1, questions.response1, questions.goodResponseIndex1);
        pointScore += askQuestion(questions.question2, questions.response2, questions.goodResponseIndex2);
        pointScore += askQuestion(questions.question3, questions.response3, questions.goodResponseIndex3);

        Game game = new Game(playerName, pointScore, new Date());
        raiting.games.add(game);
        Collections.sort(raiting.games);

        System.out.println("\nВаш результат: " + pointScore + " из 3");

        System.out.println("\nРейтинг игроков:");
        printRaiting(raiting);
    }

    private static int askQuestion(String question, String[] responses, int correctIndex) {
        System.out.println("\n" + question);
        for (int i = 0; i < responses.length; i++) {
            System.out.println((i + 1) + ". " + responses[i]);
        }

        System.out.print("Ваш ответ: ");
        int answer = scanner.nextInt();
        //scanner.nextLine(); // consume newline
        System.out.println();

        if (answer - 1 == correctIndex) {
            System.out.println("Правильно!");
            return 1;
        } else {
            System.out.println("Неверно! Правильный ответ: " + (correctIndex + 1) + ". " + responses[correctIndex]);
            return 0;
        }
    }

    private static void printRaiting(Raiting raiting) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        System.out.println();
        System.out.println("Имя\t\tОчки\tДата");
        for (Game game : raiting.games) {
            System.out.printf("%-10s\t%d\t%s%n",
                    game.gamer,
                    game.raiting,
                    dateFormat.format(game.gameDate));
        }
    }
}