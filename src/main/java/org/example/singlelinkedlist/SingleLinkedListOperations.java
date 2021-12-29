package org.example.singlelinkedlist;

public class SingleLinkedListOperations {

    public static SingleLinkedList<Integer> mergeSortedLists(SingleLinkedList<Integer> list1, SingleLinkedList<Integer> list2) {
        var l1 = list1.getHead();
        var l2 = list2.getHead();
        LinkedListNode<Integer> resultHead = null;
        LinkedListNode<Integer> resultCurrent = null;

        if (l1 == null) {
            return new SingleLinkedList<>(l2);
        }
        if (l2 == null) {
            return new SingleLinkedList<>(l1);
        }

        while (l1 != null && l2 != null) {
            Integer newElementData;
            if (l1.getData() < l2.getData()) {
                newElementData = l1.getData();
                l1 = l1.getNext();
            } else {
                newElementData = l2.getData();
                l2 = l2.getNext();
            }

            LinkedListNode<Integer> newElement = new LinkedListNode<>(newElementData, null);
            if (resultCurrent == null) {
                resultCurrent = newElement;
                resultHead = newElement;
            } else {
                resultCurrent.setNext(newElement);
                resultCurrent = resultCurrent.getNext();
            }
        }

        if (l1 != null) {
            resultCurrent.setNext(l1);
        }
        if (l2 != null) {
            resultCurrent.setNext(l2);
        }

        return new SingleLinkedList<>(resultHead);
    }

    public static SingleLinkedList<Integer> removeElementFromMiddle(SingleLinkedList<Integer> list) {
        if (list.getHead() == null || list.getHead().getNext() == null) {
            return new SingleLinkedList<>();
        }
        if (list.getHead().getNext().getNext() == null) {
            return new SingleLinkedList<>(list.getHead().getNext().getData());
        }

        var slowIterator = list.getHead();
        var fastIterator = list.getHead();
        LinkedListNode<Integer> previousSlow = null;

        while (fastIterator.getNext() != null && fastIterator.getNext().getNext() != null) {
            previousSlow = slowIterator;
            slowIterator = slowIterator.getNext();
            fastIterator = fastIterator.getNext().getNext();
        }

        previousSlow.setNext(slowIterator.getNext());

        return list;
    }

    public static SingleLinkedList<Integer> insertElementAtPosition(SingleLinkedList<Integer> list, int data, int position) {
        if (position == 0) {
            var newNode = new LinkedListNode<>(data, list.getHead());
            return new SingleLinkedList<>(newNode);
        }

        var node = list.getHead();
        int counter = 1;

        while (counter < position) {
            node = node.getNext();
            counter++;
        }

        var newNode = new LinkedListNode<>(data, node.getNext());
        node.setNext(newNode);

        return list;
    }
}
