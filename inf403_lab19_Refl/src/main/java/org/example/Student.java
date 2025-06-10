package org.example;

public class Student {
    public String lastName;
    public String firstName;
    public String middleName;
    public String group;
    public Integer age;

    public Student() {
    }

    public Student(String lastName, String firstName, String middleName, String group, Integer age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.group = group;
        this.age = age;
    }
}