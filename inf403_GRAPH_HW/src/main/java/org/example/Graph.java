package org.example;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<Thread> threads = new ArrayList<>();

    public void threads() {
        threads.add(new Thread(() -> {
            System.out.println("1");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }));
        threads.add(new Thread(() -> {
            try {
                threads.get(0).join();
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("2");
        }));
        threads.add(new Thread(() -> {
            try {
                threads.get(0).join();
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("3");
        }));
        threads.add(new Thread(() -> {
            try {
                threads.get(1).join();
                threads.get(2).join();
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("4");
        }));
        threads.add(new Thread(() -> {
            try {
                threads.get(1).join();
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("5");
        }));
        threads.add(new Thread(() -> {
            try {
                threads.get(4).join();
                threads.get(3).join();
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("6");
        }));
        threads.add(new Thread(() -> {
            try {
                threads.get(2).join();
                Thread.sleep(11000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("7");
        }));
        threads.add(new Thread(() -> {
            try {
                threads.get(5).join();
                threads.get(6).join();
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("8");
        }));
        threads.add(new Thread(() -> {
            try {
                threads.get(6).join();
                threads.get(7).join();
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("9");
        }));
        threads.add(new Thread(() -> {
            try {
                threads.get(8).join();
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("10");
        }));
    }

    public void start() {
        for (int i = 0; i < threads.size(); i++) {
            threads.get(i).start();
        }
    }
}
