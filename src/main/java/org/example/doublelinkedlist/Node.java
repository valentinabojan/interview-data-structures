package org.example.doublelinkedlist;

public class Node<T> {

    private T data;
    private Node<T> next;
    private Node<T> prev;

    public Node(T data, Node<T> prev, Node<T> next) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public T getData() {
        return data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    public Node<T> getPrev() {
        return prev;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node<?> that = (Node<?>) o;

        if (data != null) {
            return data.equals(that.getData());
        }

        return that.getData() == null;
    }
}
