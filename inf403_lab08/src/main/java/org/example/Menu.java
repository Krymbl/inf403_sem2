package org.example;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Menu implements Iterable<String>{

    private String[] dishes;

    public Menu() {
        dishes = new String[] {"Рыба", "Мясо", "Картошка", "Макароны"};
    }


    public Iterator<String> iterator() {
        return new MenuIterator();
    }

    class MenuIterator implements Iterator<String> {
        private int currentIndex = -1;

        public boolean hasNext() {
            System.out.println("hasNext " + currentIndex);
            return currentIndex < dishes.length - 1;
        }

        public String next() {
            if (currentIndex == dishes.length - 1){
                throw new NoSuchElementException();
            }
            return dishes[++currentIndex];
        }
    }
}
