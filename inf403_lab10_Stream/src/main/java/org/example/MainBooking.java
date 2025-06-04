package org.example;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class MainBooking {

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Bookings bookings =
                mapper.readValue(new File("bookings.json"), Bookings.class);

        printCount(bookings);
        printCountWomen(bookings);
        fromMoscow(bookings);
    }

    // Посчитать количество записей
    public static void printCount(Bookings bookings) {
        System.out.println(
                bookings
                        .getBookings()
                        .stream()
                        .count()
        );

    }

    // Вывести количество женщин
    public static void printCountWomen(Bookings bookings) {
        System.out.println(
                bookings
                        .getBookings()
                        .stream()
                        .filter(b -> b.getPerson().getGender() != null)
                        .filter(b -> b.getPerson().getGender().equals("Female"))
                        .count()
        );

    }
    public static void fromMoscow(Bookings bookings) {
        System.out.println(
                bookings.getBookings()
                        .stream()
                        .filter(b ->b.getPerson().getFromcity().contains("Москва"))
                        .count()
        );

    }
}
