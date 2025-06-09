import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class MainStreamPerson {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        initPersonList(persons);

        // Получить младшего из людей
        Person litle = persons
                .stream()
                .min((p1, p2) -> p1.getAge() - p2.getAge()).get();

        System.out.println(litle);

        // Получить список людей в верхнем регистре

        List<String> names = persons
                .stream()
                .map(p -> p.getName().toUpperCase())
                .collect(Collectors.toList());

        names.stream().forEach(s-> System.out.println(s));

        long size = persons
                .stream()
                .count();
        System.out.println(size);


        List<Person> pNamePersons = persons
                .stream()
                .filter(s -> s.getName().charAt(0) == 'П')
                .toList();
        System.out.println(pNamePersons);

        List<Integer> lenNames = persons
                .stream()
                .map(s -> s.getName().length())
                .distinct()
                .toList();

        System.out.println(lenNames);

        persons.stream()
                .sorted((p1,p2) -> p1.getName().compareTo(p2.getName()))
                .toList()
                .forEach(p -> System.out.println(p));


    }

    private static void initPersonList(List<Person> persons) {
        persons.add(new Person("Пушкин", 30));
        persons.add(new Person("Гоголь", 43));
        persons.add(new Person("Маяковский", 21));
        persons.add(new Person("Есенин", 18));
        persons.add(new Person("Паустовский", 24));
        persons.add(new Person("Толстой", 70));
        persons.add(new Person("Достоевский", 25));
    }
}
