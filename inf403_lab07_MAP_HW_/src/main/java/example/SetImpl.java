package example;

import java.lang.reflect.Array;

public class SetImpl<T> implements Set403<T> {
    private Object[] values;
    private int size;

    public SetImpl() {
        values = new Object[10];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (values[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(T element) {
        if (!contains(element)) {
            if (size >= values.length) {
                grow();
            }
            values[size++] = element;
        }
    }

    public T[] getAll(T[] c) {
        T[] newVal = (T[])Array.newInstance(c.getClass().componentType(),size);
        for (int i = 0; i < size; i++) {
            newVal[i] = (T)values[i];
        }

        System.out.println(newVal.getClass());
        return newVal;
    }

    @Override
    public T remove(T element) {
        Object[] newValues = new Object[size];
        int j = 0;
        T answer = null;
        for (int i = 0; i < size; i++) {
            if (!values[i].equals(element)) {
                newValues[j] = values[i];
                j++;
            } else {
                answer = element;
            }
        }
        values = newValues;
        size--;
        return answer;
    }

    public void grow() {
        Object[] newValues = new Object[(int) (size*1.5)];
        for (int i = 0; i < size; i++) {
            newValues[i] = values[i];
        }
        values = newValues;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(values[i].toString()).append(" ");
        }
        return stringBuilder.toString();
    }

}