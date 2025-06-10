package example;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class List403Impl<T> implements List403<T>, Iterable <T> {
    private Object[] values;
    private int size;

    public List403Impl(){
        this.values = new Object[10];
        this.size = 0;
    }
    public void add(T element){
        if (size >= values.length) {
            grow();
        }
        values[size++] = element;

    }
    public void add(T element, int position) throws IndexOutOfBoundsException{
        System.nanoTime();
        if (position > size || position < 0){
            throw new IndexOutOfBoundsException();
        }
        if (size == values.length) {
            grow();
        }
        for (int i = size; i != position; i--) {
            values[i] = values[i-1];
        }
        values[position] = element;
        size++;
    }
    public T remove(int position) throws IndexOutOfBoundsException{
        if (position > size-1 || position < 0){
            throw new IndexOutOfBoundsException();
        }
        T temp = (T)values[position];
        for (int i = position; i < size - 1 ; i++) {
            values[i] = values[i + 1];
        }
        size--;
        return temp;

    }
    public T get(int position) throws IndexOutOfBoundsException{
        if (position > size-1 || position < 0){
            throw new IndexOutOfBoundsException();
        }
        return (T)values[position];
    }
    public int size(){
        return size;
    }

    private void grow() {
        Object[] newValues = new Object[(int) (size*1.5)];
        for (int i = 0; i < size; i++) {
            newValues[i] = values[i];
        }
        values = newValues;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < size; ++i) {
            stringBuilder.append(values[i]).append(" ");
        }

        return stringBuilder.toString();
    }
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;
            @Override
            public boolean hasNext() {
                return currentIndex < size(); // Используем ваш метод size()
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return get(currentIndex++);
            }
        };
    }

}