package org.example;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();


        Menu2 menu2 = new Menu2();
        Iterator<String> iterator= menu2.iterator();
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());

    }
}