package org.example.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(50000);
            //ожидаем подключение клиента
            Socket clientSocket = serverSocket.accept();
            //дождались клиента
            // Поток для чтения данных от клиента
            InputStream is = clientSocket.getInputStream();
            // Поток для передачи данных клиенту
            OutputStream os = clientSocket.getOutputStream();

            byte[] buffer = new byte[100];
            // Читаем послание от клиента
            int r = is.read(buffer);
            System.out.println(new String(buffer,0,r));
            // Отправляем клиенту
            os.write("Hello from server".getBytes());
            os.flush();

            clientSocket.close();
            serverSocket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
