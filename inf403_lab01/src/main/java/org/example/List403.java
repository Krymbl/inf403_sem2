package org.example;

public interface List403 {

    /**
     * Метод добавляет элемент в конец списка
     * @param element
     */
    void add(Integer element);

    /**
     * Метод добавляет элемент в указанную позицию
     * @param element
     */
    void add(Integer element, int position) throws IndexOutOfBoundsException;

    /**
     * Удаляет элемент из списка позицию position и возвращает его
     * @param position
     * @return
     */
    Integer remove(int position) throws IndexOutOfBoundsException;

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
    Integer get(int position) throws IndexOutOfBoundsException;

    /**
     * Сортировка списка (asc = True - по возрастанию)
     */
    boolean sort(boolean asc);

}
