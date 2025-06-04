package org.example;

import java.io.*;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("text.txt"));
            FileOutputStream fos = new FileOutputStream("text1.txt")) {
            String line;
            while ((line = br.readLine()) != null) {
                fos.write((line + "\n").getBytes());
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}