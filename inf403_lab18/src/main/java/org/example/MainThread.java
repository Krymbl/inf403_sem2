package org.example;

public class MainThread  implements CallBack{

    public static void main(String[] args) {
        new MainThread().work();
    }

    public void work() {
        Thread2 thread2 = new Thread2(this);
        new Thread(String.valueOf(thread2)).start();
        while (true) {
            System.out.println("work");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void call() {
        System.out.println("File read is completed");
    }
}

