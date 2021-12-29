package org.example.doublelinkedlist;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.doublelinkedlist.DoubleLinkedListOperations.insertElementInSortedList;
import static org.example.doublelinkedlist.DoubleLinkedListOperations.insertSumOfEveryTwoNeighbourElements;
import static org.example.doublelinkedlist.DoubleLinkedListOperations.removeDuplicates;
import static org.example.doublelinkedlist.DoubleLinkedListOperations.removeElementFromMiddle;
import static org.example.doublelinkedlist.DoubleLinkedListOperations.reverse;

class DoubleLinkedListOperationsTest {

    @Test
    void removeDuplicatesFromSortedList() {
        DoubleLinkedList<Integer> originalList = new DoubleLinkedList<>(1, 2, 2, 3, 5, 5, 5, 9, 9);
        DoubleLinkedList<Integer> expectedList = new DoubleLinkedList<>(1, 2, 3, 5, 9);
        System.out.println("original list: " + originalList);
        System.out.println("expected list: " + expectedList);

        DoubleLinkedList<Integer> actual = removeDuplicates(originalList);

        assertThat(actual).isEqualTo(expectedList);
    }

    @Test
    void reverseList() {
        DoubleLinkedList<Integer> originalList = new DoubleLinkedList<>(1, 2, 3);
        DoubleLinkedList<Integer> expectedList = new DoubleLinkedList<>(3, 2, 1);
        System.out.println("original list: " + originalList);
        System.out.println("expected list: " + expectedList);

        DoubleLinkedList<Integer> actual = reverse(originalList);

        assertThat(actual).isEqualTo(expectedList);
    }

    @Test
    void removeElementFromTheMiddleOfTheList() {
        assertThat(removeElementFromMiddle(new DoubleLinkedList<>())).isEqualTo(new DoubleLinkedList<>());
        assertThat(removeElementFromMiddle(new DoubleLinkedList<>(1))).isEqualTo(new DoubleLinkedList<>());
        assertThat(removeElementFromMiddle(new DoubleLinkedList<>(1, 2))).isEqualTo(new DoubleLinkedList<>(2));
        assertThat(removeElementFromMiddle(new DoubleLinkedList<>(1, 2, 3))).isEqualTo(new DoubleLinkedList<>(1, 3));
        assertThat(removeElementFromMiddle(new DoubleLinkedList<>(1, 2, 3, 4))).isEqualTo(new DoubleLinkedList<>(1, 3, 4));
        assertThat(removeElementFromMiddle(new DoubleLinkedList<>(1, 2, 3, 4, 5))).isEqualTo(new DoubleLinkedList<>(1, 2, 4, 5));
    }

    @Test
    void insertSumOfEveryTwoNeighbourListElements() {
        DoubleLinkedList<Integer> originalList1 = new DoubleLinkedList<>(1, 2, 5, 6, 7, 9);
        DoubleLinkedList<Integer> expectedList1 = new DoubleLinkedList<>(1, 3, 2, 7, 5, 11, 6, 13, 7, 16, 9);
        DoubleLinkedList<Integer> actual1 = insertSumOfEveryTwoNeighbourElements(originalList1);
        assertThat(actual1).isEqualTo(expectedList1);

        DoubleLinkedList<Integer> originalList2 = new DoubleLinkedList<>();
        DoubleLinkedList<Integer> expectedList2 = new DoubleLinkedList<>();
        DoubleLinkedList<Integer> actual2 = insertSumOfEveryTwoNeighbourElements(originalList2);
        assertThat(actual2).isEqualTo(expectedList2);

        DoubleLinkedList<Integer> originalList3 = new DoubleLinkedList<>(1);
        DoubleLinkedList<Integer> expectedList3 = new DoubleLinkedList<>(1);
        DoubleLinkedList<Integer> actual3 = insertSumOfEveryTwoNeighbourElements(originalList3);
        assertThat(actual3).isEqualTo(expectedList3);

        DoubleLinkedList<Integer> originalList4 = new DoubleLinkedList<>(1, 2);
        DoubleLinkedList<Integer> expectedList4 = new DoubleLinkedList<>(1, 3, 2);
        DoubleLinkedList<Integer> actual4 = insertSumOfEveryTwoNeighbourElements(originalList4);
        assertThat(actual4).isEqualTo(expectedList4);
    }

    @Test
    void insertInSortedList() {
        DoubleLinkedList<Integer> originalList1 = new DoubleLinkedList<>(1, 3, 4, 10);
        DoubleLinkedList<Integer> expectedList1 = new DoubleLinkedList<>(1, 3, 4, 5, 10);
        DoubleLinkedList<Integer> actual1 = insertElementInSortedList(originalList1, 5);
        assertThat(actual1).isEqualTo(expectedList1);

        DoubleLinkedList<Integer> originalList2 = new DoubleLinkedList<>(2, 3, 4);
        DoubleLinkedList<Integer> expectedList2 = new DoubleLinkedList<>(1, 2, 3, 4);
        DoubleLinkedList<Integer> actual2 = insertElementInSortedList(originalList2, 1);
        assertThat(actual2).isEqualTo(expectedList2);

        DoubleLinkedList<Integer> originalList3 = new DoubleLinkedList<>(5, 6, 7);
        DoubleLinkedList<Integer> expectedList3 = new DoubleLinkedList<>(5, 6, 7, 8);
        DoubleLinkedList<Integer> actual3 = insertElementInSortedList(originalList3, 8);
        assertThat(actual3).isEqualTo(expectedList3);

        DoubleLinkedList<Integer> originalList4 = new DoubleLinkedList<>();
        DoubleLinkedList<Integer> expectedList4 = new DoubleLinkedList<>(1);
        DoubleLinkedList<Integer> actual4= insertElementInSortedList(originalList4, 1);
        assertThat(actual4).isEqualTo(expectedList4);

        DoubleLinkedList<Integer> originalList5 = new DoubleLinkedList<>(1);
        DoubleLinkedList<Integer> expectedList5 = new DoubleLinkedList<>(1, 2);
        DoubleLinkedList<Integer> actual5= insertElementInSortedList(originalList5, 2);
        assertThat(actual5).isEqualTo(expectedList5);
    }
}