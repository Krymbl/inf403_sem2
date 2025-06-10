package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TransportService {

    private File fileName;

    public TransportService(String fileName) {
        this.fileName = new File(fileName);
    }


    //Считывание всех транспортов
    public List403Impl<Transport> readAll() {
        try {

            Scanner sc = new Scanner(fileName);
            List403Impl<Transport> result = new List403Impl<>();

            if (sc.hasNextLine()) { //Пропускам заголовок в файле
                sc.nextLine();
            }

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] str = line.split(";");

                result.add(
                        switch (str[0]) {
                            case "bus" -> new Bus(str[1], str[2], str[3], str[4]);
                            case "tram" -> new Tram(str[1], str[2], str[3], str[4]);
                            case "trolleybus" -> new Trolleybus(str[1], str[2], str[3], str[4]);
                            default -> null;
                        }
                );
            }
            sc.close();
            return result;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List403Impl<Bus> readAllBus() throws FileNotFoundException {
        Scanner sc = new Scanner(fileName);
        List403Impl<Bus> result = new List403Impl<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] str = line.split(";");
            if (str[0].equals("bus")) {
                result.add(new Bus(str[1], str[2], str[3], str[4]));
            }
        }

        sc.close();
        return result;
    }

    public List403Impl<Trolleybus> readAllTrolleybus() throws FileNotFoundException {
        Scanner sc = new Scanner(fileName);
        List403Impl<Trolleybus> result = new List403Impl<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] str = line.split(";");
            if (str[0].equals("trolleybus")) {
                result.add(new Trolleybus(str[1], str[2], str[3], str[4]));
            }
        }

        sc.close();
        return result;
    }

    public List403Impl<Tram> readAllTram() throws FileNotFoundException {
        Scanner sc = new Scanner(fileName);
        List403Impl<Tram> result = new List403Impl<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] str = line.split(";");
            if (str[0].equals("tram")) {
                result.add(new Tram(str[1], str[2], str[3], str[4]));
            }
        }
        sc.close();
        return result;
    }

    public void sortredRouteNumber() { //Упорядоченный вид номера маршрутов, время начала и окончнания движения маршрута
        List403Impl<Transport> list = readAll();

        if (list == null || list.size() == 0) {
            System.out.println("Ошибка");
            return;
        }

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int num1 = Integer.parseInt(list.get(i).routeNumber);
                int num2 = Integer.parseInt(list.get(j).routeNumber);

                if (num1 > num2) {
                    list.swap(i, j);
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            Transport t = list.get(i);
            System.out.println("Номер: " + t.routeNumber + " | Время начала : " + t.workTimeBegin + " | Время окончания : " + t.workTimeEnd);
        }
    }

    public void sortredNumber() {  //Упорядоченном вид парковые номера и время начала движения

        List403Impl<Transport> list = readAll();

        if (list == null || list.size() == 0) {
            System.out.println("Ошибка");
            return;
        }


        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int num1 = Integer.parseInt(list.get(i).number);
                int num2 = Integer.parseInt(list.get(j).number);

                if (num1 > num2) {
                    list.swap(i, j);
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            Transport t = list.get(i);
            System.out.println("Парковый номер: " + t.number + " | Время начала : " + t.workTimeBegin);
        }
    }


    public void printUniqRouteNumber() { // По списку вывести кол-во разных маршрутов

        List403Impl<Transport> list = readAll();
        SetImpl<String> set = new SetImpl<>();

        for (int i = 0; i < list.size(); i++) {
            set.add(list.get(i).getRouteNumber());
        }

        System.out.println("Уникальные номера маршрутов: ");
        set.getAll();
        System.out.println("Количество уникальных маршрутов: " + set.size());
    }


    public void printUniqTransport()  { //кол-во разных транспортных средств
        List403Impl<Transport> list = readAll();
        SetImpl<String> set = new SetImpl<>();

        for (int i = 0; i < list.size(); i++) {
            set.add(list.get(i).getNumber());
        }

        System.out.println("Уникальные транспортные средства: ");
        set.getAll();
        System.out.println("Количество транспортных средств: " + set.size());

    }

    public void printCntTransp() { //номер маршрута и кол-во транспортных средств на нем
        List403Impl<Transport> list = readAll();

        if (list == null || list.size() == 0) {
            System.out.println("Список пуст");
            return;
        }

        SetImpl<String> processedTransport = new SetImpl<>(); // Множество для учёта обработанных транспортов
        List403Impl<RouteCount> routeCounts = new List403Impl<>(); // Список для хранения пар [номер маршрута, количество]

        for (int i = 0; i < list.size(); i++) {
            Transport t = list.get(i);

            if (processedTransport.contains(String.valueOf(t))) {
                continue; // Пропускаем уже обработанные
            }

            int count = 0;
            String currentRoute = t.getRouteNumber();
            //Считаем количество транспорта на маршруте

            for (int j = 0; j < list.size(); j++) {
                Transport other = list.get(j);

                if (currentRoute.equals(other.getRouteNumber())) {
                    count++;
                    processedTransport.add(String.valueOf(other));
                }
            }
            routeCounts.add(new RouteCount(currentRoute, count));
        }

        for (int i = 0; i < routeCounts.size(); i++) {
            RouteCount rc = routeCounts.get(i);
            System.out.println("Маршрут " + rc.routeNumber + ": " + rc.count + " шт.");
        }
    }

    private static class RouteCount {
        String routeNumber;
        int count;

        RouteCount(String routeNumber, int count) {
            this.routeNumber = routeNumber;
            this.count = count;
        }
    }
}