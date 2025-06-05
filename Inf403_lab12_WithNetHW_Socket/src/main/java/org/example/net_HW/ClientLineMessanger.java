package org.example.net_HW;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ClientLineMessanger {
    public static void main(String[] args) {

        try {
            Socket socket = new Socket("127.0.0.1", 50000);

//            // Поток для чтения данных от сервера
//            DataInputStream is = new DataInputStream(socket.getInputStream());
//            // Поток для передачи данных серверу
//            DataOutputStream os = new DataOutputStream(socket.getOutputStream());

            while (true) {

                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));

                BufferedReader consoleInput = new BufferedReader(
                        new InputStreamReader(System.in, StandardCharsets.UTF_8));

                String message = consoleInput.readLine();

                out.write(message + "\n");
                out.flush();
                if (message.equals("exit")) {
                    break;
                }

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));

                message = in.readLine();
                System.out.println(message);

                if (message.equals("exit")) {
                    break;
                }
            }
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
