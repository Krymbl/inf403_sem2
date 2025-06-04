package org.example;

public abstract class Transport {
    protected String number;
    protected String routeNumber;
    protected String workTimeBegin;
    protected String workTimeEnd;

    public Transport() {}

    public Transport(String number, String routeNumber, String workTimeBegin, String workTimeEnd) {
        this.number = number;
        this.routeNumber = routeNumber;
        this.workTimeBegin = workTimeBegin;
        this.workTimeEnd = workTimeEnd;
    }

    public String getNumber() {
        return number;
    }

    public String getRouteNumber() {
        return routeNumber;
    }

    public String getWorkTimeBegin() {
        return workTimeBegin;
    }

    public String getWorkTimeEnd() {
        return workTimeEnd;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setRouteNumber(String routeNumber) {
        this.routeNumber = routeNumber;
    }

    public void setWorkTimeBegin(String workTimeBegin) {
        this.workTimeBegin = workTimeBegin;
    }

    public void setWorkTimeEnd(String workTimeEnd) {
        this.workTimeEnd = workTimeEnd;
    }


}