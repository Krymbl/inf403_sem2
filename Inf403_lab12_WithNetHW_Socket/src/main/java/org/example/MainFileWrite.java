package org.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class MainFileWrite {
    public static void main(String[] args) {
        try(OutputStream fos = new FileOutputStream("text.txt")) {
            String[] strings = {"Тест ","записи ", "в файл "};

            for (String s : strings) {
                fos.write(s.getBytes(StandardCharsets.UTF_8));
            }

            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
