package org.example;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        ListImpl<Integer> list = new ListImpl<Integer>();
        list.add(2,0);
        list.add(3);
        list.add(4);
        list.add(5,3);
        list.remove(3);
        System.out.println(list.get(2));
        System.out.println(list.size());
        System.out.println(list);

    }
}