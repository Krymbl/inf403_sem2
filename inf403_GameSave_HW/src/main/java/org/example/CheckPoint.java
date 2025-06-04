package org.example;

import java.io.*;

public class CheckPoint<T>{

    private String fileName;

    public CheckPoint(String fileName) {
        this.fileName = fileName;
    }

    public void save(T object) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(object);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public T load() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (T) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}