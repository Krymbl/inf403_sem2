package org.example;

import java.util.Scanner;

public class Console {
    private Playlist playlist;
    private Track currentTrack;
    private int trackNumber;
    private PlaySound playSound;

    public Console() {
        this.playlist = new Playlist();
        playlist.load();
        this.playSound = new PlaySound();

    }

    public void showMenu() {
        System.out.println("-----------------------------");
        System.out.println("Проигрывается:\n" + currentTrack);
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
                "10.Удалить трек\n" +
                "11.Очистить плейлист\n" +
                "12.Выход");
        System.out.println("-----------------------------\n");
    }

    public void startCommand() {
        boolean flag = true;
        while (flag) {
            showMenu();
            System.out.print("Введите команду: ");
            while (true) {
                Scanner scan = new Scanner(System.in);
                try {
                    int command = scan.nextInt();
                    flag = commandHandler(command);
                    break;
                } catch (Exception e) {
                    System.out.println("Номер команды!");
                }
            }

        }
    }

    public boolean commandHandler(int command) {
        switch (command) {
            case 1: //Сделано
                playlist.showAll();
                break;
            case 2: //Сделано
                System.out.println("Напишите название трека");
                Scanner scanName = new Scanner(System.in);
                String name = scanName.nextLine();
                System.out.println("Найденные треки: ");
                playlist.findByName(name);
                break;
            case 3: //Сделано
                System.out.println("Напишите имя автора");
                Scanner scanAuthor = new Scanner(System.in);
                String author = scanAuthor.nextLine();
                System.out.println("\nНайденные треки: ");
                playlist.findByAuthor(author);
                break;
            case 4: //Сделано
                System.out.println("Напишите номер трека");
                while (true) {
                    Scanner scanSound = new Scanner(System.in);
                    try {
                        trackNumber = scanSound.nextInt();
                        break;
                    } catch (Exception e) {
                        System.out.println("Номер трека!");
                    }
                }
                System.out.println("Найденные треки: ");
                System.out.println(playlist.findByNumber(trackNumber).toString());
                break;
            case 5: //Сделано
                System.out.println("Введите номер трека");
                while (true) {
                    Scanner scanSound = new Scanner(System.in);
                    try {
                        trackNumber = scanSound.nextInt();
                        break;
                    } catch (Exception e) {
                        System.out.println("Номер трека!");
                    }
                }


                if (trackNumber < 1 || trackNumber > playlist.getSize()) {
                    System.out.println("Нет трека с таким номером");
                    break;
                }
                if (currentTrack != null) {
                    playSound.stop();
                }
                playSound.play((playlist.findByNumber(trackNumber)));
                currentTrack = playlist.findByNumber(trackNumber);
                break;
            case 6: //Сделано
                playSound.stop();
                currentTrack = null;
                break;
            case 7: //Сделано
                if (currentTrack == null) {
                    System.out.println("Никакой трек не играет");
                    break;
                } else if (currentTrack.getNumber() + 1 > playlist.getSize()) {
                    System.out.println("Нет следующих треков");
                    break;
                }
                System.out.println("Запущен следующий трек " + currentTrack.getNumber());
                playSound.stop();
                playSound.play(playlist.findByNumber(currentTrack.getNumber() + 1));
                currentTrack = playlist.findByNumber(currentTrack.getNumber() + 1);
                break;
            case 8: //Сделано
                if (currentTrack == null) {
                    System.out.println("Никакой трек не играет");
                    break;
                } else if (currentTrack.getNumber() - 1 < 1) {
                    System.out.println("Нет предыдущих треков" );
                    break;
                }
                System.out.println("Запущен предыдущий трек");
                playSound.stop();
                playSound.play(playlist.findByNumber(currentTrack.getNumber() - 1));
                currentTrack = playlist.findByNumber(currentTrack.getNumber() - 1);
                break;
            case 9: //Сделано
                Scanner scan = new Scanner(System.in);
                System.out.println("Введите название трека");
                String addName = scan.nextLine();
                System.out.println("Введите имя автора");
                String addAuthor = scan.nextLine();
                System.out.println("Абсолютный путь нахождения трека");
                String addPath = scan.nextLine();

                playlist.add(new Track(addName, addAuthor, addPath));
                break;
            case 10: //Сделано
                System.out.println("Введите номер трека");
                Scanner scanRemove = new Scanner(System.in);
                playlist.delete(scanRemove.nextInt());
                break;
            case 11: //Сделано
                playlist.clear();
                System.out.println("Плейлист очищен");
                break;
            case 12: //Сделано
                return false;
            default: //Сделано
                System.out.println("Нет такой команды, введите заново");
        }
        return true;

    }
}
