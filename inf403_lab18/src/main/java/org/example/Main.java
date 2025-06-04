package org.example;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * Текст перевести в ByteArrayInputStream,
 * скопировать побайтно в ByteArrayOutputStream,
 * записать в файл. Написать тест
 * процедуры копирования.
 */
public class Main {
    public static  ByteArrayOutputStream copy(ByteArrayInputStream bais) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int r;
        while((r = bais.read()) != -1) {
            baos.write(r);
        }
        return baos;
    }

}