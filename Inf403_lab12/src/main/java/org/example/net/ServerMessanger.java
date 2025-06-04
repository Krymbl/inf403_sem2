package org.example.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerMessanger {
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

            while (true) {


                // Читаем пакет от клиента
                int size = is.readInt(); // размер сообщения
                byte[] buffer = new byte[size]; //готовим буфер нужного размера
                is.read(buffer); //читаем сообщение

                String message = new String(buffer);
                System.out.println(message);
                if (message.equals("exit")) {
                    break;
                }

                Scanner scanner = new Scanner(System.in);

                // Отправляем пакет клиенту
                message = scanner.nextLine();
                // Измеряем кол-во байт в сообщении
                size = message.getBytes().length;

                os.writeInt(size); //заголовок пакета
                os.write(message.getBytes()); //тело пакета
                os.flush();

                if (message.equals("exit")) {
                    break;
                }
            }
            clientSocket.close();
            serverSocket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
