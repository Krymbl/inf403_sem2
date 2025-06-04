package org.example;

public interface List<T> {

    void add(T element);

    void add(T element, int position) throws IndexOutOfBoundsException;

    T remove(int position) throws IndexOutOfBoundsException;

    int size();

    T get(int position) throws IndexOutOfBoundsException;
}
