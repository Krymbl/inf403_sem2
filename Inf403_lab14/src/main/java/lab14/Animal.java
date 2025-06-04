package lab14;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


public class Animal implements Serializable {
    public static long version = 0;

    private String name;
    private int age;
    private AnimalType type;
    private AnimalClass category;

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(AnimalClass category) {
        this.category = category;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setType(AnimalType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return (name + " " + age + " " + type + " " + category);
    }
}
