package org.example.net_HW;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * каждое сообщение заканчивается на \n
 * befferedWriteer использоватьс
 */
public class ServerLineMessanger {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(50000);
            //ожидаем подключение клиента
            Socket clientSocket = serverSocket.accept();
            //дождались клиента
//            // Поток для чтения данных от клиента
//            DataInputStream is = new DataInputStream(clientSocket.getInputStream());
//            // Поток для передачи данных клиенту
//            DataOutputStream os = new DataOutputStream(clientSocket.getOutputStream());

            while (true) {

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream(), StandardCharsets.UTF_8));

                String message = in.readLine();
                System.out.println(message);
                if (message.equals("exit")) {
                    break;
                }

                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream(), StandardCharsets.UTF_8));

                BufferedReader consoleInput = new BufferedReader(
                        new InputStreamReader(System.in, StandardCharsets.UTF_8));

                message = consoleInput.readLine();

                System.out.println(message);

                out.write(message + "\n");
                out.flush();

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
