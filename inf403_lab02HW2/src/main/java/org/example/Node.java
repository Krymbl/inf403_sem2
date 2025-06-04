package org.example;

public class Node <T> {
    public Node next;
    public Node prev;
    public T value;

    public Node(T value) {
        this.value = value;
    }
}
