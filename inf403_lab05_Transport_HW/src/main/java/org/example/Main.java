package org.example;

import java.io.FileNotFoundException;

///
///     - По списку вывести в упорядоченном виде парковые номера и время начала движения
///     - По списку вывести в упорядоченном виде номера маршрутов, время начала и окончнания движения маршрута
///     - По списку вывести кол-во разных маршрутов
///     - По списку вывести кол-во разных транспортных средств
///     - По списку вывести номер маршрута и кол-во транспортных средств на нем
///



public class Main {
    public static void main(String[] args) throws FileNotFoundException {


        TransportService transportService = new TransportService("C:\\Users\\dasts\\Desktop\\Itis\\lol\\inf403_sem2\\transport.csv");


        List403Impl<Transport> list = transportService.readAll();
        //System.out.println(list);

        transportService.sortredNumber();

        System.out.println("-----------------------");

        transportService.sortredRouteNumber();

        System.out.println("-----------------------");

        transportService.printUniqRouteNumber();

        System.out.println("-----------------------");

        transportService.printUniqTransport();

        System.out.println("-----------------------");

        transportService.printCntTransp();

        System.out.println("-----------------------");

    }
}