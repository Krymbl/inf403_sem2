package org.example.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Общение в рамках договоренности о формате сообщений(Протокол)
 * длина сообщения (4 байта) \ сообщение заявленной длины
 */
public class ServerProtacol {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(50000);
            //ожидаем подключение клиента
            Socket clientSocket = serverSocket.accept();
            //дождались клиента
            // Поток для чтения данных от клиента
            DataInputStream is = new DataInputStream(clientSocket.getInputStream());
            // Поток для передачи данных клиенту
            DataOutputStream os = new DataOutputStream(clientSocket.getOutputStream());

            // Читаем пакет от клиента
            int size = is.readInt(); // размер сообщения
            byte[] buffer = new byte[size]; //готовим буфер нужного размера
            is.read(buffer); //читаем сообщение
            System.out.println(new String(buffer));

            // Отправляем пакет клиенту
            String message = "Hello from сервер";
            // Измеряем кол-во байт в сообщении
            size = message.getBytes().length;

            os.writeInt(size); //заголовок пакета
            os.write(message.getBytes()); //тело пакета
            os.flush();

            clientSocket.close();
            serverSocket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
