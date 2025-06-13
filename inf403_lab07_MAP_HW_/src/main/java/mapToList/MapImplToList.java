package mapToList;

import example.*;
import mapIterator.MapImplIterator;


import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class MapImplToList<K,V> implements Map<K,V> {

    private Node<K,V>[] array; // Массив "корзин" (buckets) для хранения данных

    private int size; // Счетчик количества элементов в мапе

    private class Node<K,V> {  // Узел связного списка для разрешения коллизий
        Entry<K,V> value;
        Node<K,V> next;

        public Node(K key, V value) {
            this.value = new EntryImpl<>(key, value); // Создаем новую Entry
        }
    }

    class EntryImpl<K,V> implements Entry<K,V> {  // Реализация интерфейса Entry
        private K key;
        private V value;

        public EntryImpl(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public void setKey(K key) {
            this.key = key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }
    }

    public MapImplToList(){
        array = new Node[16];  // Инициализация массива из 16 корзин
    }

    @Override
    public void put(K key, V value) { // Добавление пары ключ-значение
        int index = Math.abs(key.hashCode() % 16); // Вычисление индекса корзины
        Node<K,V> temp = new Node<>(key,value);
        if (array[index] == null) {
            array[index] = temp;   // Если корзина пуста, добавляем узел
        } else {

            Node<K,V> current = array[index]; // Начинаем обход цепочки
            Node<K,V> prev = null;
            while (current != null) {  // Обход цепочки, пока не дойдем до конца
                if (current.value.getKey().equals(key)) { // Если ключ уже существует, то обновляем значени
                    current.value.setValue(value);
                    return;
                }
                prev = current; //Запоминаем текущий узел как предыдущий
                current = current.next; // Переходим к следующему узлу в цепочке
            }

//            if (prev == null) { //Добавляем новый узел в конец цепочки
//                array[index] = temp; //Проверяем, был ли список пуст, Если пуст - делаем новый узел головой списка
//            } else {
                prev.next = temp; //Если список не пуст, Добавляем новый узел в конец цепочки
//            }
        }
        size++;
    }


    @Override
    public V get(K key) {
        int index = Math.abs(key.hashCode() % 16);  // Вычисление индекса корзины
        if (array[index] == null) { // Если корзина пуста, то ключ не найден
            return null;
        }
        Node<K,V> current = array[index];
        while(current != null) { // Начинаем обход цепочки, пока не дойдем до конца.
            if(current.value.getKey().equals(key)) { //Если нашли ключ, то возвращаем значение
                return current.value.getValue();
            }
            current = current.next;
        }
        return null;
    }

    @Override
    public Set403<K> keySet() {   // Получение множества всех ключей
        SetImpl<K> set = new SetImpl<>();

        for (Node<K, V> node: array){ // Обходим все корзины
            while (node != null){ // Обходим все узлы в цепочке, Добавляем ключ в множество, Переходим к следующему узлу
                set.add(node.value.getKey());
                node = node.next;
            }
        }
        return set;
    }

    @Override
    public List403<V> values() { // список значений
        List403<V> values = new List403Impl<>();
        for (int i = 0; i < array.length; i++) {
            Node<K, V> current = array[i];
            while (current != null) {
                values.add(current.value.getValue());
                current = current.next;
            }
        }
        return values;
    }

    @Override
    public int size() { // Получение количества элементов
        return size;
    }

    @Override
    public boolean containsKey(K key) { // Проверка наличия ключа
        int index = Math.abs(key.hashCode() % 16); // Вычисление индекса корзины

        if (array[index] == null){ // Если корзина пуста, ключа нет
            return false;
        }

        Node<K, V> current = array[index];
        while (current != null){
            if (current.value.getKey().equals(key)){ //Если нашли ключ, возвращаем true
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean isEmpty() { // Проверка на пустоту
        return size == 0;
    }

    @Override
    public boolean containsValue(V value) {  // Проверка наличия значения
        for (Node<K, V> node: array){ //Обходим все корзины
            while (node != null){ // Обходим все узлы в цепочке
                if (node.value.getValue().equals(value)) {  //Если нашли значение, возвращаем true
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }

    @Override
    public V remove(K key) {  // Удаление элемента по ключу
        int index = Math.abs(key.hashCode() % 16); // Вычисление индекса корзины

        Node<K, V> current = array[index]; // Текущий узел
        Node<K, V> previous = null; // Предыдущий узел

        while (current != null){ // Обход цепочки
            if (current.value.getKey().equals(key)) { // Если нашли ключ, то сохраняем значение
                V removedValue = current.value.getValue();

                if (previous == null){ //Если это первый узел в цепочке, Перенаправляем голову
                    array[index] = current.next;
                }else{                   //Если это не первый узел, то убираем текущий узел
                    previous.next = current.next;
                }
                size--;
                return removedValue;   // Возвращаем удаленное значение
            }
            previous = current;  // Запоминаем предыдущий узел
            current = current.next;   // Переходим к следующему
        }
        return null;
    }

    @Override
    public void clear() {
        for (int i = 0; i < array.length; i++){
            array[i] = null;
        }
        size = 0;
    }
    class MapIterator implements Iterator<Entry<K,V>> {
        private int curIndex=0;
        private K[] arrayKeys = keySet().getAll((K[]) new Object[0]); //Получаем все ключи в виде массива элементов множества
        @Override   //Создаёт пустой массив типа Object длиной 0 (Нужен только для передачи типа)
        public boolean hasNext() {
            return curIndex < arrayKeys.length;
        }
        @Override
        public Entry<K,V> next() {
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            K key = arrayKeys[curIndex++];
            return new EntryImpl(key,get(key)); // Возвращаем Entry
        }
    }
    public <R> List403<R> map(Function<V,R> mapper) { //принимает функцию, которая преобразует V → R
        List403<R> result = new List403Impl<>(); //<R> позволяет указать, что метод работает с произвольным типом
        for (V elem : values()) {
            result.add(mapper.apply(elem)); //apply вызывает функцию преобразования для текущего элемента
        }
        return result;
    }
}