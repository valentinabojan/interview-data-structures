package org.example.singlelinkedlist;

public class SingleLinkedList<T> {

    private LinkedListNode<T> head;
    private LinkedListNode<T> tail;

    public SingleLinkedList(LinkedListNode<T> head) {
        this.head = head;
    }

    public SingleLinkedList(T... elements) {
        if (elements.length == 0) {
            return;
        }

        this.head = new LinkedListNode<>(elements[0], null);
        this.tail = this.head;

        for (int i = 1; i < elements.length; i++) {
            addToEndOfList(elements[i]);
        }
    }

    public LinkedListNode<T> getHead() {
        return head;
    }

    private void addToEndOfList(T data) {
        LinkedListNode<T> newNode = new LinkedListNode<>(data, null);
        this.tail.setNext(newNode);
        this.tail = newNode;
    }

    public SingleLinkedList<T> reverse() {
        if (this.head.getNext() == null) {
            return this;
        }

        LinkedListNode<T> previous = null;
        LinkedListNode<T> next = this.head.getNext();
        while (next != null) {
            this.head.setNext(previous);
            previous = this.head;
            this.head = next;
            next = next.getNext();
        }
        this.head.setNext(previous);

        return this;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SingleLinkedList<?> that = (SingleLinkedList<?>) o;

        LinkedListNode<?> firstListHead = this.head;
        LinkedListNode<?> secondListHead = that.head;

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
