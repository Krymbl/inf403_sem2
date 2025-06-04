package org.example;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class Menu2 implements Iterable<String>{

    private String dish1;
    private String dish2;
    private String dish3;
    private String dish4;

    public Menu2() {
        dish1 = "Рыба";
        dish2 = "Мясо";
        dish3 = "Картошка";
        dish4 = "макароны";
    }


    public Iterator<String> iterator() {
        return new MenuIterator();
    }

    class MenuIterator implements Iterator<String> {
        private int currentIndex = 0;

        public boolean hasNext() {
            return currentIndex < 4;
        }

        public String next() {
            if (currentIndex == 4){
                throw new NoSuchElementException();
            }
            return switch (currentIndex++){
                case 0 -> dish1;
                case 1 -> dish2;
                case 2 -> dish3;
                case 3 -> dish4;
                default -> throw new NoSuchElementException();
            };
        }
    }
}
