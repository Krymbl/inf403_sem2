package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TransportService {
    private File file;

    public TransportService(String fileName) {
        file = new File(fileName);
    }
    public List403<Transport> readAll() throws FileNotFoundException,IllegalStateException {
        Scanner sc = new Scanner(file);
        if (sc.hasNextLine()) {
            sc.nextLine();
        }
        List403Impl<Transport> list = new List403Impl();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] array = line.split(";");
            list.add(switch (array[0]) {
                case "bus" -> new Bus(array[1],array[2],array[3],array[4]);
                case "tram" -> new Tram(array[1],array[2],array[3],array[4]);
                case "trolleybus" -> new Trolleybus(array[1],array[2],array[3],array[4]);
                default -> null;
            });
        }
        sc.close();
        return list;
    }

    public List403<Bus> readAllBus() throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        if (sc.hasNextLine()) {
            sc.nextLine();
        }
        List403Impl<Bus> list = new List403Impl();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] array = line.split(";");
            if (array[0].equals("bus")) list.add(new Bus(array[1],array[2],array[3],array[4]));
        }
        sc.close();
        return list;
    }

    public List403<Tram> readAllTram() throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        if (sc.hasNextLine()) {
            sc.nextLine();
        }
        List403Impl<Tram> list = new List403Impl();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] array = line.split(";");
            if (array[0].equals("tram")) list.add(new Tram(array[1],array[2],array[3],array[4]));
        }
        sc.close();
        return list;
    }

    public List403<Trolleybus> readAllTrolleybus() throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        if (sc.hasNextLine()) {
            sc.nextLine();
        }
        List403Impl<Trolleybus> list = new List403Impl();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] array = line.split(";");
            if (array[0].equals("trolleybus")) list.add(new Trolleybus(array[1],array[2],array[3],array[4]));
        }
        sc.close();
        return list;
    }

    public static List403<? extends Transport> sortParkNumbers(List403<? extends Transport> list) {
        for (int i = list.size()-1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (Integer.parseInt(list.indexOf(i).getNumber())<Integer.parseInt(list.indexOf(j).getNumber())) {
                    list.set(i,j);
                }
            }
        }
        return list;
    }

    public static List403<? extends Transport> sortRouteNumbers(List403<? extends Transport> list) {
        for (int i = list.size()-1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (Integer.parseInt(list.indexOf(i).getRouteNumber())<Integer.parseInt(list.indexOf(j).getRouteNumber())) {
                    list.set(i,j);
                }
            }
        }
        return list;
    }
}