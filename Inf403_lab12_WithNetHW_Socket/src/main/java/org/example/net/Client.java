package org.example.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {

        try {
            Socket socket = new Socket("127.0.0.1", 50000);

            // Поток для чтения данных от сервера
            InputStream is = socket.getInputStream();
            // Поток для передачи данных серверу
            OutputStream os = socket.getOutputStream();

            // Отправляем сообщение на сервер
            os.write("Hello from client".getBytes());
            os.flush();

            byte[] buffer = new byte[100];
            // Читаем послание от сервера
            int r = is.read(buffer);
            System.out.println(new String(buffer,0,r));

            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
