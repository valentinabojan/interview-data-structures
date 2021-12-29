package org.example.singlelinkedlist;

public class LinkedListNode<T> {

    private T data;
    private LinkedListNode<T> next;

    public LinkedListNode(T data, LinkedListNode<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LinkedListNode<T> getNext() {
        return next;
    }

    public void setNext(LinkedListNode<T> next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LinkedListNode<?> that = (LinkedListNode<?>) o;

        if (data != null) {
            return data.equals(that.getData());
        }

        return that.getData() == null;
    }
}
