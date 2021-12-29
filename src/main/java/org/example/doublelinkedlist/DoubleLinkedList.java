package org.example.doublelinkedlist;

public class DoubleLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;

    public DoubleLinkedList(Node<T> head) {
        this.head = head;
    }

    public DoubleLinkedList(T... elements) {
        if (elements.length == 0) {
            return;
        }

        this.head = new Node<>(elements[0], null, null);
        this.tail = this.head;

        for (int i = 1; i < elements.length; i++) {
            addToEndOfList(elements[i]);
        }
    }

    private void addToEndOfList(T data) {
        Node<T> newNode = new Node<>(data, null, null);
        this.tail.setNext(newNode);
        newNode.setPrev(tail);
        this.tail = newNode;
    }

    public Node<T> getHead() {
        return head;
    }

    @Override
    public String toString() {
        String str = "";
        Node<T> node = this.head;
        while (node != null) {
            str += node.getData() + " ";
            node = node.getNext();
        }

        return str;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DoubleLinkedList<?> that = (DoubleLinkedList<?>) o;

        Node<?> firstListHead = this.head;
        Node<?> secondListHead = that.head;

        while (firstListHead != null && secondListHead != null) {
            if (!firstListHead.equals(secondListHead)) {
                return false;
            }

            firstListHead = firstListHead.getNext();
            secondListHead = secondListHead.getNext();
        }

        if (firstListHead != null || secondListHead != null) {
            return false;
        }

        return true;
    }
}
