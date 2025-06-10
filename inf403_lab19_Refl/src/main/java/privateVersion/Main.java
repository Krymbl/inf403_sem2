package privateVersion;

import java.lang.reflect.InvocationTargetException;

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
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}