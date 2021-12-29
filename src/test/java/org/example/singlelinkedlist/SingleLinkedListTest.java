package org.example.singlelinkedlist;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.singlelinkedlist.SingleLinkedListOperations.insertElementAtPosition;
import static org.example.singlelinkedlist.SingleLinkedListOperations.mergeSortedLists;
import static org.example.singlelinkedlist.SingleLinkedListOperations.removeElementFromMiddle;

class SingleLinkedListTest {

    @Test
    void reverseList() {
        SingleLinkedList<Integer> originalList = new SingleLinkedList<>(1, 2, 3);
        SingleLinkedList<Integer> expectedList = new SingleLinkedList<>(3, 2, 1);
        System.out.println("original list: " + originalList);
        System.out.println("expected list: " + expectedList);

        SingleLinkedList<Integer> reversedList = originalList.reverse();
        System.out.println("actual list: " + reversedList);

        assertThat(reversedList).isEqualTo(expectedList);
    }

    @Test
    void mergeTwoSortedLists() {
        SingleLinkedList<Integer> list1 = new SingleLinkedList<>(1, 2, 5, 9);
        SingleLinkedList<Integer> list2 = new SingleLinkedList<>(2, 3, 7, 8, 10);
        SingleLinkedList<Integer> expectedList = new SingleLinkedList<>(1, 2, 2, 3, 5, 7, 8, 9, 10);
        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2);

        SingleLinkedList<Integer> actual = mergeSortedLists(list1, list2);
        System.out.println("actual list: " + actual);

        assertThat(actual).isEqualTo(expectedList);
    }

    @Test
    void removeElementFromTheMiddleOfTheList() {
        assertThat(removeElementFromMiddle(new SingleLinkedList<>())).isEqualTo(new SingleLinkedList<>());
        assertThat(removeElementFromMiddle(new SingleLinkedList<>(1))).isEqualTo(new SingleLinkedList<>());
        assertThat(removeElementFromMiddle(new SingleLinkedList<>(1, 2))).isEqualTo(new SingleLinkedList<>(2));
        assertThat(removeElementFromMiddle(new SingleLinkedList<>(1, 2, 3))).isEqualTo(new SingleLinkedList<>(1, 3));
        assertThat(removeElementFromMiddle(new SingleLinkedList<>(1, 2, 3, 4))).isEqualTo(new SingleLinkedList<>(1, 3, 4));
        assertThat(removeElementFromMiddle(new SingleLinkedList<>(1, 2, 3, 4, 5))).isEqualTo(new SingleLinkedList<>(1, 2, 4, 5));
    }

    @Test
    void insertElementAtPositionInList() {
        SingleLinkedList<Integer> list1 = new SingleLinkedList<>(16, 13, 7);
        SingleLinkedList<Integer> actual1 = insertElementAtPosition(list1, 1, 2);
        assertThat(actual1).isEqualTo(new SingleLinkedList<>(16, 13, 1, 7));

        SingleLinkedList<Integer> list2 = new SingleLinkedList<>(16, 13, 7);
        SingleLinkedList<Integer> actual2 = insertElementAtPosition(list2, 1, 0);
        assertThat(actual2).isEqualTo(new SingleLinkedList<>(1, 16, 13, 7));

        SingleLinkedList<Integer> list3 = new SingleLinkedList<>(16, 13, 7);
        SingleLinkedList<Integer> actual3 = insertElementAtPosition(list3, 1, 1);
        assertThat(actual3).isEqualTo(new SingleLinkedList<>(16, 1, 13, 7));

        SingleLinkedList<Integer> list4 = new SingleLinkedList<>(16, 13, 7);
        SingleLinkedList<Integer> actual4 = insertElementAtPosition(list4, 1, 3);
        assertThat(actual4).isEqualTo(new SingleLinkedList<>(16, 13, 7, 1));
    }
}