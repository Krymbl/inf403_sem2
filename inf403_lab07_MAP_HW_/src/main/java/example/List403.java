package example;

public interface List403 <T> extends Iterable<T>{

    /**
     * Метод добавляет элемент в конец списка
     * @param element
     */
    void add(T element);

    /**
     * Метод добавляет элемент в указанную позицию
     * @param element
     */
    void add(T element, int position) throws IndexOutOfBoundsException;

    /**
     * Удаляет элемент из списка позицию position и возвращает его
     * @param position
     * @return
     */
    T remove(int position) throws IndexOutOfBoundsException;

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
    T get(int position) throws IndexOutOfBoundsException;

    /**
     * Сортировка списка (asc = True - по возрастанию)
     */

}
