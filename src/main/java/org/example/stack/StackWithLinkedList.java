package org.example.stack;

import org.example.singlelinkedlist.LinkedListNode;

public class StackWithLinkedList<T> implements Stack<T> {

    LinkedListNode<T> head;

    @Override
    public void push(T data) {
        this.head = new LinkedListNode<>(data, head);
    }

    @Override
    public T pop() {
        if (head == null) {
            return null;
        }

        T data = head.getData();
        head = head.getNext();
        return data;
    }

    @Override
    public T peek() {
        if (head == null) {
            return null;
        }

        return head.getData();
    }

    @Override
    public String toString() {
        String str = "";
        LinkedListNode<T> i = this.head;
        while (i != null) {
            str += i.getData() + " ";
            i = i.getNext();
        }

        return str;
    }
}
