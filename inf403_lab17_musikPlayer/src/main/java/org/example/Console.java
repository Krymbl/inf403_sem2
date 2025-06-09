package org.example;

import java.util.Scanner;

public class Console {
    private Playlist playlist;
    private Track currentTrack;

    public Console() {
        this.playlist = new Playlist();
        playlist.load();
    }

    public void showMenu() {
        System.out.println("\n-----------------------------");
        System.out.println("Проигрывается: " + currentTrack);
        System.out.println("-----------------------------");
        System.out.println("1.Показать все треки\n" +
                "2.Найти трек по названию\n" +
                "3.Найти трек по автору\n" +
                "4.Найти по номеру\n" +
                "5.Проиграть трек по номеру\n" +
                "6.Остановить проигрывание\n" +
                "7.Следующий трек\n" +
                "8.Предыдущий трек\n" +
                "9.Добавить трек\n" +
                "10.Очистить плейлист\n" +
                "11.Выход");
        System.out.println("-----------------------------\n");
    }

    public void startCommand() {
        boolean flag = true;
        while (flag) {
            Scanner scan = new Scanner(System.in);
            showMenu();
            System.out.println("Введите команду\n");
            try {
                int command = scan.nextInt();
                flag = commandHandler(command);
            } catch (Exception e) {
                System.out.println("Номер команды!\n");
            }

        }
    }

    public boolean commandHandler(int command) {
        switch (command) {
            case 9:
                Scanner scan = new Scanner(System.in);
                System.out.println("Введите название трека");
                String addName = scan.nextLine();
                System.out.println("Введите имя автора");
                String addAuthor = scan.nextLine();
                System.out.println("Абсолютный путь нахождения трека");
                String addPath = scan.nextLine();
                System.out.println("Добавлен трек: " + addName + " - " + addAuthor);
                playlist.add(new Track(addName, addAuthor, addPath));
                break;
            case 10:
                playlist.clear();
                System.out.println("Плейлист очищен");
                break;
            case 11:
                return false;
            case 1:

                playlist.showAll();
                break;
            case 2:
                System.out.println("Напишите название трека");
                Scanner scanName = new Scanner(System.in);
                String name = scanName.nextLine();
                System.out.println("\nНайденные треки: ");
                playlist.findByName(name);
                break;
            case 3:
                System.out.println("Напишите имя автора");
                Scanner scanAuthor = new Scanner(System.in);
                String author = scanAuthor.nextLine();
                System.out.println("\nНайденные треки: ");
                playlist.findByAuthor(author);
                break;
            case 4:
                System.out.println("Напишите номер трека");
                Scanner scanNumber = new Scanner(System.in);
                Integer number = scanNumber.nextInt();
                System.out.println("\nНайденные треки: ");
                System.out.println(playlist.findByNumber(number).toString());
                break;
            case 5:
                if (currentTrack == null) {
                    System.out.println("Введите номер трека");
                    Scanner scanSound = new Scanner(System.in);
                    Integer soundNumber = scanSound.nextInt();
                    PlaySound.play(playlist.findByNumber(soundNumber));
                    currentTrack = playlist.findByNumber(soundNumber);
                } else {
                    System.out.println("Уже играет трек: " + currentTrack);
                }

                break;
            case 6:
                PlaySound.stop();
                currentTrack = null;
                break;

            default:
                System.out.println("Нет такой команды, введите заново");
        }
        return true;

    }
}
