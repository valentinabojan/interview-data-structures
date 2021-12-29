package org.example.doublelinkedlist;

public class DoubleLinkedListOperations {

    public static DoubleLinkedList<Integer> removeDuplicates(DoubleLinkedList<Integer> list) {
        var node = list.getHead();

        while (node.getNext() != null) {
            if (node.getData() == node.getNext().getData()) {
                if (node.getNext().getNext() != null) {
                    node.getNext().getNext().setPrev(node);
                }
                node.setNext(node.getNext().getNext());
            } else {
                node = node.getNext();
            }
        }

        return list;
    }

    public static DoubleLinkedList<Integer> reverse(DoubleLinkedList<Integer> list) {
        var node = list.getHead();

        if (node == null) {
            return list;
        }

        while (true) {
            var prev = node.getPrev();
            var next = node.getNext();

            node.setPrev(next);
            node.setNext(prev);
            if (next != null) {
                node = next;
            } else {
                break;
            }
        }

        return new DoubleLinkedList<>(node);
    }

    public static DoubleLinkedList<Integer> removeElementFromMiddle(DoubleLinkedList<Integer> list) {
        if (list.getHead() == null || list.getHead().getNext() == null) {
            return new DoubleLinkedList<>();
        }
        if (list.getHead().getNext().getNext() == null) {
            return new DoubleLinkedList<>(list.getHead().getNext().getData());
        }

        var slow = list.getHead();
        var fast = list.getHead().getNext();

        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        var prev = slow.getPrev();
        var next = slow.getNext();
        prev.setNext(next);
        next.setPrev(prev);

        return list;
    }

    public static DoubleLinkedList<Integer> insertSumOfEveryTwoNeighbourElements(DoubleLinkedList<Integer> list) {
        var node = list.getHead();
        if (node == null || node.getNext() == null) {
            return list;
        }

        while (node.getNext() != null) {
            var next = node.getNext();

            var newNode = new Node<>(node.getData() + next.getData(), node, next);
            node.setNext(newNode);
            next.setPrev(newNode);

            node = next;
        }

        return list;
    }

    public static DoubleLinkedList<Integer> insertElementInSortedList(DoubleLinkedList<Integer> list, int data) {
        if (list.getHead() == null) {
            return new DoubleLinkedList<>(data);
        }

        var node = list.getHead();
        while (node.getNext() != null && node.getNext().getData() < data) {
            node = node.getNext();
        }

        if (node.getPrev() == null && node.getData() >= data) {
            var newNode = new Node<>(data, null, node);
            node.setPrev(newNode);
            return new DoubleLinkedList<>(newNode);
        }

        var newNode = new Node<>(data, node, node.getNext());
        if (node.getNext() != null) {
            node.getNext().setPrev(newNode);
        }
        node.setNext(newNode);
        return list;
    }
}
