package org.example;

public class List403Impl implements List403 {

    private Integer[] values;
    private int size;

    public List403Impl() {
        this.size = 0;
        this.values = new Integer[10];
    }


    public void add(Integer element) {
        if (size >= values.length) {
            grow();
        }
        values[size++] = element;
    }

    public void add(Integer element, int position) throws IndexOutOfBoundsException {
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

    public Integer remove(int position) throws IndexOutOfBoundsException {
        if (position > size  || position < 0) {
            throw new IndexOutOfBoundsException("Зашли за массив");
        }
        Integer temp = values[position];
        for (int i = position; i < size - 1; i++) {
            values[i] = values[i+1];
        }
        values[size-1] = null;
        size--;
        return temp;
    }

    public int size() {
        return size;

    }

    public Integer get(int position) throws IndexOutOfBoundsException {
        if (position > size || position < 0) {
            throw new IndexOutOfBoundsException("Зашли за массив");
        }
        return values[position];
    }

    public boolean sort(boolean asc) {
        if (asc) {
            for (int i = 0; i < size - 1; i++) {
                for (int j = 0; j < size - i - 1; j++) {
                    if (values[j] > values[j+1]) {
                        int f = values[j];
                        values[j] = values[j+1];
                        values[j+1] = f;
                    }
                }
            }
        } else {
            for (int i = 0; i < size - 1; i++) {
                for (int j = 0; j < size - i -1; j++) {
                    if (values[j] < values[j+1]) {
                        int f = values[j];
                        values[j] = values[j+1];
                        values[j+1] = f;
                    }
                }
            }
        }
        return asc;

    }

    private void grow() {
        Integer[] newValues = new Integer[(int) (size * 1.5)];
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
