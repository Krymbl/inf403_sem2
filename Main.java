import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList <Student> array = new ArrayList<>();
        array.add(new Student("Danil", 18, Kind.MAN));
        array.add(new Student("Roma", 19, Kind.MAN));
        array.add(new Student("Alena", 17, Kind.WOMAN));
        array.add(new Student("Marina", 20, Kind.WOMAN));
    }

    public static class Student {
        private String name;
        private int age;
        private Kind gender;

        public Student(String name, int age, Kind gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }
    }

    public enum Kind {
        MAN,
        WOMAN;
    }

}
