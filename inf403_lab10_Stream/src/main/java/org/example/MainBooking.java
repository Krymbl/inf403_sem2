package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

// ToDo 1. Вывести список гостиниц и кол-во бронирований женщинами
// ToDo 2. Вывести список гостиниц и кол-во бронирований мужчинами
// ToDo 3. Вывести процент бронирований из Самарской области
// ToDo 4. Вывести процент бронирований людьми в возрасте от 40 до 45 лет
// ToDo 5. Вывести список городов и кол-во бронирований по ним (город ~ г ...)
// ToDo 6. Сформировать Map ключ - гостиница, значение - список городов
// ToDo 7. Вывести процент уникальных людей (необходимо описать эквивалентность по полу, дате рождения)


public class MainBooking {
    public static void main(String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        Bookings bookings = mapper.readValue(new File("C:\\Users\\dasts\\Desktop\\Itis\\lol\\inf403_sem2\\bookings.json"),  Bookings.class);

        //printCountCity(bookings);

        //ToDo 1

        System.out.println("Cписок гостиниц и кол-во бронирований женщинами: ");
        printHotelByWomen(bookings);
        System.out.println("-----------------------------");

        //ToDo 2
        System.out.println("Cписок гостиниц и кол-во бронирований мужчинами: ");
        printHotelByMen(bookings);
        System.out.println("-----------------------------");

        //ToDo 3
        System.out.print("Процент бронировый из Самарской области: ");
        printPercentFromSamara(bookings);
        System.out.println("-----------------------------");

        //ToDO 4
        System.out.print("Процент бронирований людьми в возрасте от 40 до 45 лет: ");
        printPercentPerson(bookings);
        System.out.println("-----------------------------");

        //ToDo 5
        System.out.println("Cписок городов и кол-во бронирований из этих городов: ");
        printCountCity(bookings);

        //ToDo 7
        System.out.println("Процент уникальных людей: ");
        printUniqPersonPercent(bookings);
        System.out.println("-----------------------------");

        //ToDo 6 Вывод
        System.out.println(mapHotelCity(bookings));
    }

    //Вывести количество броней
    public static void printCount(Bookings bookings){
        System.out.println(
                bookings
                        .getBookings()
                        .stream()
                        .count()
        );
    }


    //Вывести кол-во гостей из москвы
    public static void printCountGuestFromMoscow(Bookings bookings){
        System.out.println(
                bookings
                        .getBookings()
                        .stream()
                        .filter(p -> p.getPerson().getFromcity().contains("Москва"))
                        .count()
        );
    }

    //
    public static void printHotels(Bookings bookings) {
        Map<String, Integer> result =
                bookings.getBookings()
                        .stream()
                        .collect(Collectors.toMap(
                                b -> b.getHotel().getName(),
                                b -> 1,
                                (v1,v2) -> v1+v2)
                        );
        result.entrySet()
                .stream()
                .forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));
    }

    //ToDo 1 список гостиниц и кол-во бронирований женщинами

    public static void printHotelByWomen(Bookings bookings){
        Map<String, Integer> result =
                bookings.getBookings()
                        .stream()
                        .filter(b -> {
                            if (b.getPerson().getGender() == null) {
                                return false;
                            }
                            return b.getPerson().getGender().equals("Female");})
                        .collect(Collectors.toMap(
                                b -> b.getHotel().getName(),
                                b -> 1, Integer::sum)); // Объединяем значения при дубликатах (суммируем 1)

        result.forEach((hotel, count) -> System.out.println(hotel + " : " + count));
    }

    //ToDo 2 кол-во бронирований отелей мужчнами

    public static void printHotelByMen(Bookings bookings){
        bookings.getBookings()
                .stream()
                .filter(b -> {
                    if (b.getPerson().getGender() == null) {
                        return false;
                    }
                    return b.getPerson().getGender().equals("Male");})
                .collect(Collectors.toMap(
                        b -> b.getHotel().getName(),
                        b -> 1,
                        Integer::sum
                ))
                .forEach((hotel, count) -> System.out.println(hotel + " : " + count));
    }

    //ToDo 3. Вывести процент бронирований из Самарской области

    public static void printPercentFromSamara(Bookings bookings){
        long count = bookings.getBookings()
                .stream()
                .filter(b -> b.getPerson().getFromcity() != null && b.getPerson().getFromcity().contains("Самарская область"))
                .count();

        System.out.println((double) count / bookings.getBookings().size() * 100 + " % ");
    }

    // ToDo 4. Вывести процент бронирований людьми в возрасте от 40 до 45 лет
    public static void printPercentPerson(Bookings bookings){

        long count = bookings.getBookings()
                .stream()
                .filter( b -> {
                    Date birth = b.getPerson().getBirthdate();
                    if (birth == null) return false;


                    //Конвертирует устаревший Date в современный LocalDate (для удобства расчёта возраста)
                    LocalDate birthDate = birth.toInstant() //преобразует Date в Instant (момент времени).
                            .atZone(ZoneId.systemDefault()) //добавляет временную зону (системную по умолчанию).
                            .toLocalDate(); //получает дату без времени.


                    LocalDate now = LocalDate.now(); //текущая дата
                    int age = Period.between(birthDate, now).getYears(); //вычисляет разницу между датами в годах (возраст человека).

                    return age >= 40 && age <= 45;
                })
                .count();
        System.out.println((double) count / bookings.getBookings().size() * 100 + " % ");
    }
    // ToDo 5. Вывести список городов и кол-во бронирований по ним (город ~ г ...)
    public static void printCountCity(Bookings bookings){
        bookings.getBookings()
                .stream()
                .collect(Collectors.toMap(
                        b -> b.getPerson().getFromcity(),
                        b -> 1,
                        Integer::sum
                ))
                .forEach((city, count) -> System.out.println(city + " : " + count));
    }


    // ToDo 6. Сформировать Map ключ - гостиница, значение - список городов
    public static Map<String, List<String>> mapHotelCity(Bookings bookings){
        return bookings.getBookings()
                .stream()
                .collect(Collectors.groupingBy( //Используется для группировки элементов потока по заданному критерию.
                        // возвращает Collector, который собирает элементы в Map<K, List<T>>,
                        b -> b.getHotel().getName(), //ключом в Map будет имя отеля (извлекается из каждого Booking).
                        Collectors.mapping( //преобразования элементов перед их сбором в коллекцию
                                b -> b.getPerson().getFromcity(), //извлекает город (fromcity) человека из бронирования.
                                Collectors.collectingAndThen( //Сначала собрать элементы с помощью обычного коллектора
                                        //Затем применить финальное преобразование к результату сбора
                                        Collectors.toSet(), //Удаляем дубликаты (Сохраняем все города в set)
                                        ArrayList::new //преобразует Set городов в ArrayList
                                        // (чтобы значение Map было именно List<String>, а не Set<String>).
                                )
                        )
                ));
    }

    // ToDo 7. Вывести процент уникальных людей (необходимо описать эквивалентность по полу, дате рождения)
    public static void printUniqPersonPercent(Bookings bookings){
        Set<String> uniqPerson =  bookings.getBookings()
                .stream()
                .map(b -> {
                    Person p = b.getPerson();
                    if (p == null || p.getGender() == null || p.getBirthdate() == null) return "";
                    return p.getGender() + " : " + p.getBirthdate();
                })
                .filter(string -> !string.isEmpty())
                .collect(Collectors.toSet());


        System.out.println((double)uniqPerson.size() * 100 / bookings.getBookings().size());
    }
}