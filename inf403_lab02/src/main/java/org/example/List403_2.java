package org.example;

public interface List403_2 {

    /**
     * Метод добавляет элемент в конец списка
     * @param element
     */
    void add(Object element);

    /**
     * Метод добавляет элемент в указанную позицию
     * @param element
     */
    void add(Object element, int position) throws IndexOutOfBoundsException;

    /**
     * Удаляет элемент из списка позицию position и возвращает его
     * @param position
     * @return
     */
    Object remove(int position) throws IndexOutOfBoundsException;

    /**
     * Возвращает размер списка
     * @return
     */
    int size();

    /**
     * Возвращает элемент по индексу
     * @param position
     * @return
     */
    Object get(int position) throws IndexOutOfBoundsException;

    /**
     * Сортировка списка (asc = True - по возрастанию)
     */
    boolean sort(boolean asc);

}
