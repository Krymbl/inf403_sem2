package org.example;

public class Action <T>{
    private T a;
    private T b;
    private T c;


    public T get(int x) throws IndexOutOfBoundsException {
        if (x > 2 || x < 0) {
            throw new IndexOutOfBoundsException(0);
        }
        switch(x) {
            case 0:
                return a;
            case 1:
                return b;
            case 2:
                return c;
        }
        return null;
    }

    public T add(T element, int x) throws IndexOutOfBoundsException{
        if (x > 2 || x < 0) {
            throw new IndexOutOfBoundsException(0);
        }
        switch(x) {
            case 0:
                return a = element;
            case 1:
                return b = element;
            case 2:
                return c = element;
        }
        return null;
    }

}
