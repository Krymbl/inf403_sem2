package lab14;

import java.io.*;

public class MainFile {
    public static void main(String[] args) {
        Animal animal1 = new Animal();
        animal1.setName("Лиса Алиса");
        animal1.setAge(12);
        animal1.setCategory(AnimalClass.МЛЕКОПИТАЮЩИЕ);
        animal1.setType(AnimalType.ЛИСА);

        byte[] savedData = null;

        try(FileOutputStream fos = new FileOutputStream("lisa.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(animal1);

            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        for (byte b : savedData) {
//            System.out.println(b);
//        }

        try (FileInputStream fis = new FileInputStream("lisa.obj");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            Animal animal2 = (Animal) ois.readObject();
            System.out.println(animal2);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}