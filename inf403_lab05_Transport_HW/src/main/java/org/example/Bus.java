package org.example;

public class Bus extends Transport {
    public Bus(String number, String routeNumber, String workTimeBegin, String workTimeEnd) {
        super (number, routeNumber, workTimeBegin, workTimeEnd);
    }

    @Override
    public String toString() {
        return "Bus: " + number + ", " + routeNumber + ", " + workTimeBegin + ", " + workTimeEnd;
    }
}