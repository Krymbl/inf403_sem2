package org.example;

public class Auto {
    private String mark;
    private String model;
    private int year;
    private int horsepower;

    public Auto(String mark, String model, int year, int horsepower) {
        this.mark = mark;
        this.model = model;
        this.year = year;
        this.horsepower = horsepower;
    }

    @Override
    public boolean equals(Object a) {
        if (a == null) return false;
        if (this == a) return true;
        if (a.getClass().equals(getClass())) {
            Auto b = (Auto) a;
            if (mark.equals(b.mark) && model.equals(b.model)) {
                return true;
            }
        }
        return false;
    }
}
