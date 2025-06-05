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

        System.out.println("Проигрывается: " + currentTrack);

        System.out.println("1.Показать все треки\n" +
                "2.Найти трек по названию\n" +
                "3.Найти трек по автору\n" +
                "4.Найти по номеру\n" +
                "5.Проиграть трек по номеру\n" +
                "6.Остановить проигрывание\n" +
                "7.Следующий трек\n" +
                "8.Предыдущий трек\n" +
                "9.Добавить трек\n" +
                "10.Выход");
    }

    public void startCommand() {
        Scanner scan = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            showMenu();
            System.out.println("Введите команду");
            int command = scan.nextInt();
            flag = commandHandler(command);
        }
    }

    public boolean commandHandler(int command) {
        switch (command) {
            case 10:
                return false;
            case 1:
                playlist.showAll();
                break;
            case 2:
                System.out.println("Напишите название трека");
                Scanner scanName = new Scanner(System.in);
                String name = scanName.nextLine();
                scanName.close();
                playlist.findByName(name);
                break;
            case 3:
                System.out.println("Напишите имя автора");
                Scanner scanAuthor = new Scanner(System.in);
                String author = scanAuthor.nextLine();
                scanAuthor.close();
                playlist.findByAuthor(author);
                break;
            case 4:
                System.out.println("Напишите номер трека");
                Scanner scanNumber = new Scanner(System.in);
                Integer number = scanNumber.nextInt();
                scanNumber.close();
                playlist.findByNumber(number);
                break;
        }
        return true;

    }
}
