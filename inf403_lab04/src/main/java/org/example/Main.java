package org.example;

public class Main {
    public static void main(String[] args) {
//        ListImpl<Integer> set = new ListImpl<>();
//        set.add(0);
//        set.add(1);
//        set.add(2);
//
//        System.out.println(set.getAll(new Integer[0]));

        ListImpl<Fruit> set = new ListImpl<>();
        set.add(new Fruit("Яблоко", 5));
        set.add(new Fruit("Груша", 7));
        set.add(new Fruit("Апельсин", 2));
        set.add(new Fruit("Яблоко", 5));

        Fruit a[] = set.getAll(new Fruit[0]);
        for (Fruit i : a) {
            System.out.println(i);
        }



    }
}