package org.example;

public class ArrayImpl <T> implements List <T>{

    private Object[] values;
    private int size;

    public ArrayImpl() {
        this.size = 0;
        this.values = new Integer[10];
    }


    public void add(T element) {
        if (size >= values.length) {
            grow();
        }
        values[size++] = element;
    }

    public void add(T element, int position) throws IndexOutOfBoundsException {
        if (position > size || position < 0) {
            throw new IndexOutOfBoundsException("Зашли за массив");
        }
        if (size >= values.length) {
            grow();
        }
        for (int i = size; i != position; i--) {
            values[i] = values[i-1];
        }
        values[position] = element;
        size++;
    }

    public T remove(int position) throws IndexOutOfBoundsException {
        if (position > size  || position < 0) {
            throw new IndexOutOfBoundsException("Зашли за массив");
        }
        Object temp = values[position];
        for (int i = position; i < size - 1; i++) {
            values[i] = values[i+1];
        }
        values[size-1] = null;
        size--;
        return (T)temp;
    }

    public int size() {
        return size;

    }

    public T get(int position) throws IndexOutOfBoundsException {
        if (position > size || position < 0) {
            throw new IndexOutOfBoundsException("Зашли за массив");
        }
        return (T)values[position];
    }

    private void grow() {
        Object[] newValues = new Object[(int) (size * 1.5)];
        for (int i = 0; i < size; i++) {
            newValues[i] = values[i];
        }
        values = newValues;
    }

    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < size; i++) {
            res += values[i] + " ";
        }
        return res;
    }
}
