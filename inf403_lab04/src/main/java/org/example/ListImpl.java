package org.example;

import java.lang.reflect.Array;

public class ListImpl<T> implements List<T> {
    private int size;
    private Object[] values;

    public ListImpl() {
        this.size = 0;
        this.values = new Object[10];
    }

    public int size() {
        return size;
    }

    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (values[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void add(T element) {
        if (size >= values.length) {
            grow();
        }
        if (!contains(element)) {
            values[size++] = element;
        }
    }

    public T remove(T element) {
        Object[] temp = new Object[size];
        boolean check = false;
        for (int i = 0; i < size; i++) {
            if (!check && !element.equals(values[i])) {
                temp[i] = values[i];
                size--;
            } else {
                check = true;
                temp[i] = values[i+1];
                size--;
            }
        }
        values = temp;

        return element;
    }

    public T[] getAll(T[] c) {
        T[] temp = (T[]) Array.newInstance(c.getClass().componentType(),size);
        for (int i = 0; i < size; i++) {
            temp[i]=(T)values[i];
        }

        values = temp;
        System.out.println(temp.getClass());
        return temp;
    }

    public void grow() {
        Object[] newValues = new Object[(int) (size * 1.5)];
        for (int i = 0; i < size; i++) {
            newValues[i] = values[i];
        }
        values = newValues;
    }

    public String toString() {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < size; i++) {
            string.append(values[i]).append(" ");
        }
        return string.toString();
    }
}
