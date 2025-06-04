package org.example;

public class Main {
    public static void main(String[] args) {
        ListImpl<Integer> list = new ListImpl<Integer>();
        ArrayImpl<Integer> array = new ArrayImpl<Integer>();
        int n = 100000;

        long a = System.nanoTime();
        for (int i = 0; i < n; i++) {
            list.add(2);
        }
        long b = System.nanoTime();
        System.out.println("Добавление в список: " + (b - a));


        a = System.nanoTime();
        for (int i = 0; i < n; i++) {
            array.add(2);
        }
        b = System.nanoTime();
        System.out.println("Добавление в массив: " + (b - a));

        a = System.nanoTime();
        for (int i = 0; i < n; i++) {
            list.add(2,2);
        }
        b = System.nanoTime();
        System.out.println("Добавление в список в позицию 2: " + (b - a));

        a = System.nanoTime();
        for (int i = 0; i < n; i++) {
            array.add(2,2);
        }
        b = System.nanoTime();
        System.out.println("Добавление в массив в позицию 2: " + (b - a));

        a = System.nanoTime();
        for (int i = 0; i < n; i++) {
            list.remove(2);
        }
        b = System.nanoTime();
        System.out.println("Удаление из списка в позиции 2: " + (b - a));

        a = System.nanoTime();
        for (int i = 0; i < n; i++) {
            array.remove(2);
        }
        b = System.nanoTime();
        System.out.println("Удаление из массива в позиции 2: " + (b - a));
    }
}