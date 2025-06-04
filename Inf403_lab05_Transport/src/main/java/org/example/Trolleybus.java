package org.example;

public class Trolleybus extends Transport {
    public Trolleybus(String number, String routeNumber, String workTimeBegin, String workTimeEnd) {
        super (number, routeNumber, workTimeBegin, workTimeEnd);
    }

    @Override
    public String toString() {
        return "Trolleybus: " + number + ", " + routeNumber + ", " + workTimeBegin + ", " + workTimeEnd;
    }


}