package org.example;

public class Tram extends Transport {
    public Tram(String number, String routeNumber, String workTimeBegin, String workTimeEnd) {
        super (number, routeNumber, workTimeBegin, workTimeEnd);
    }

    @Override
    public String toString() {
        return "Tram: " + number + ", " + routeNumber + ", " + workTimeBegin + ", " + workTimeEnd;
    }
}