package org.example;

public class Main {
    public static void main(String[] args) {
        JSONMapper mapper = new JSONMapper();

        Student student = new Student(
                "Поттер",
                "Гарри",
                "Джеймсович",
                "11-гриффиндор",
                12
        );

        try {
            System.out.println(mapper.toJson(student));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}