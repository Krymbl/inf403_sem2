package org.example;

public class ListImpl<T> implements List <T> {
    
    private int size;
    private Node first;
    private Node tail;

    public ListImpl() {
        this.size = 0;
        this.first = null;
        this.tail = null;
    }

    public void add(T element) {
        if (first == null) {
            first = new Node(element);
            size = 1;
        } else {
            Node current = first;
            while (current.next != null) {
                current=current.next;
            }
            tail = new Node(element);
            current.next = tail;
            tail.prev = current;
            size++;
        }
    }

    public void add(T element, int position) throws IndexOutOfBoundsException {
        if (position > size || position < 0) {
            throw new IndexOutOfBoundsException("Зашли за список");
        }
       
        Node current = first;
        Node newNode = new Node(element);
        for (int i = 0; i < position; i++) {
            current=current.next;
        }

        if (position == size) {
            add(element);
        } else if (position == 0){
            newNode.next=current;
            current.prev=newNode;
            first=newNode;
            size++;

        } else {
            newNode.prev = current.prev;
            newNode.next = current;
            newNode.prev.next = newNode;
            current.prev = newNode;
            size++;
        }

    }

    public T remove(int position) throws IndexOutOfBoundsException {
        if (position > size  || position < 0) {
            throw new IndexOutOfBoundsException("Зашли за список");
        }
        Node current = first;
        for (int i = 0; i < position; i++) {
            current=current.next;
        }
        if (position == 0) {
            first=current.next;
            current.next.prev = null;
            current.next = null;
            size--;
        } else if (position == size - 1){
            tail = current.prev;
            current.prev.next = null;
            current.prev = null;
            size--;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
            current.next=null;
            current.prev=null;
            size--;
        }
        return null;
    }

    public int size() {
        return size;
    }

    public T get(int position) throws IndexOutOfBoundsException {
        if (position > size || position < 0) {
            throw new IndexOutOfBoundsException("Зашли за список");
        }
        Node current = first;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }
        return (T)current.value;
        
    }
    

    public String toString() {
        StringBuilder string = new StringBuilder();
        Node current = first;
        for (int i = 0; i < size; i++) {
            string.append(current.value).append(" ");
            current=current.next;
        }
        return string.toString();
    }
}
