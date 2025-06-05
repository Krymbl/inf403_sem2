package org.example.net;

import java.io.*;
import java.net.Socket;

/**
 * Общение в рамках договоренности о формате сообщений(Протокол)
 * длина сообщения (4 байта) \ сообщение заявленной длины
 */
public class ClientProtocol {
    public static void main(String[] args) {

        try {
            Socket socket = new Socket("127.0.0.1", 50000);

            // Поток для чтения данных от сервера
            DataInputStream is = new DataInputStream(socket.getInputStream());
            // Поток для передачи данных серверу
            DataOutputStream os = new DataOutputStream(socket.getOutputStream());

            // Отправляем сообщение на сервер
            String message = "Hello from client";
            // Измеряем кол-во байт в сообщении
            int size = message.getBytes().length;

            os.writeInt(size); //заголовок пакета
            os.write(message.getBytes()); //тело пакета
            os.flush();

            size = is.readInt(); // размер сообщения
            byte[] buffer = new byte[size]; //готовим буфер нужного размера
            is.read(buffer); //читаем сообщение
            System.out.println(new String(buffer));

            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
