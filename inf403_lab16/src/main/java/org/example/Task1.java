package org.example;

public class Task1 implements Runnable  {

    @Override
    public void run() {
        int vertex = 0;
        while (true) {
            for (int i = 0; i < 11; i++) {
                if (!Graph.readAndWrite(i)) {

                }
            }
        }
    }
}
