package org.example;

import java.util.Date;
import java.util.Objects;

public class Person {
    private String gender;
    private Date birthdate;
    private String fromcity;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getFromcity() {
        return fromcity;
    }

    public void setFromcity(String fromcity) {
        this.fromcity = fromcity;
    }

    @Override
    public String toString() {
        return birthdate + "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(gender, person.gender) && Objects.equals(birthdate, person.birthdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gender, birthdate);
    }
}