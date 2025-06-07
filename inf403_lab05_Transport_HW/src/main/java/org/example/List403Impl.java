package org.example;

import java.util.Comparator;

public class List403Impl<T> implements List403<T>{
    private T[] array;
    private int size;

    public List403Impl() {
        this.array = (T[]) new Object[10];
        this.size = 0;
    }
    private void grow() {
        T[] newarray = (T[]) new Object[(int)(size*1.5)];
        for (int i = 0; i < size; i++) {
            newarray[i] = array[i];
        }
        array = newarray;
    }
    public void add(T a){
        if (size==array.length) {
            grow();
        }
        array[size++] = a;
    } // добавляет элемент в конец списка
    public void add(int pos, T a) throws IndexOutOfBoundsException {
        if (pos>size-1 || pos<0) {
            throw new IndexOutOfBoundsException();
        }
        if (size==array.length) {
            grow();
        }
        for (int i = size; i > pos ; i--) {
            array[i] = array[i-1];
        }
        size++;
        array[pos] = a;
    } //добавляет элемент в указанную позицию
    public T remove(int pos) throws IndexOutOfBoundsException{
        if (pos>size-1 || pos<0) {
            throw new IndexOutOfBoundsException();
        }
        T value = array[pos];
        for (int i = pos; i < size-1; i++) {
            array[i] = array[i+1];
        }
        size--;
        return value;
    } //удаляет элемент по индексу и выводит его
    public int size(){
        return size;
    } //возвращает размер
    public T get(int position) throws IndexOutOfBoundsException {
        if (position>size-1 || position<0) {
            throw new IndexOutOfBoundsException();
        } else {
            return array[position];
        }
    } // обращение по индексу

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < size; i++) {
            s.append(array[i]).append(" ").append("\n");
        }
        return s.toString();
    }

    public void swap(int pos1, int pos2) {
        T temp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = temp;
    }

    public void sort(Comparator<T> comparator) {
        for (int i = size()-1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (comparator.compare(array[i],array[j])<0) {
                    swap(i,j);
                }
            }
        }
    }







}