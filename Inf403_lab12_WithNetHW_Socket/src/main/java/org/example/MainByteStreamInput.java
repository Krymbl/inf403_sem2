package org.example;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainByteStreamInput {
    public static void main(String[] args) {

        byte[] bytes = {1, 2, 3, 4, 5, 6, 7, 8};
        try (InputStream is = new ByteArrayInputStream(bytes)){
            int r;

            while ((r = is.read()) > -1) {
                System.out.println(r);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
