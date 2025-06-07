package org.example;

import java.io.*;

public class LoadAndSaves {
    private static String questionFile = "QuestinFile.txt";
    private static String raitingFile = "RaitingFile.txt";

    public Questions loadQuestions() throws IOException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(questionFile))) {
            return (Questions) ois.readObject();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveQuestions(Questions questions) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(questionFile))) {
            oos.writeObject(questions);
        }
    }

    public Raiting loadRaiting() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(raitingFile))) {
            return (Raiting) ois.readObject();
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    public void saveRaiting(Raiting raiting) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(raitingFile))) {
            oos.writeObject(raiting);
        }
    }

}
