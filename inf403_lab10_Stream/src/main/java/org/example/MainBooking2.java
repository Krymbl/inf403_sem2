package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;

public class MainBooking2 {

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Bookings bookings =
                mapper.readValue(new File("bookings.json"), Bookings.class);

        //printChild(bookings);
        printHotels(bookings);
    }

    public static void printChild(Bookings bookings) {
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd")
                    .parse("2011-04-23");
            bookings.getBookings()
                    .stream()
                    .filter(p -> p.getPerson().getBirthdate() != null)
                    .filter(p -> p.getPerson().getBirthdate().after(date))
                    .map(b -> b.getPerson())
                    .toList()
                    .forEach(System.out::println);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }

    public static void printHotels(Bookings bookings) {
        Map<String, Integer> result =
                bookings.getBookings()
                        .stream()
                        .collect(Collectors.toMap(
                                        b -> b.getHotel().getName(),
                                        b -> 1,
                                        (v1,v2) -> v1+v2)
                                //мяу
                        );
        result.entrySet()
                .stream()
                .forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));
    }
}