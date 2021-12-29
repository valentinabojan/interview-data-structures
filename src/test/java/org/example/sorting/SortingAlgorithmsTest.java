package org.example.sorting;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SortingAlgorithmsTest {

    @Test
    void bubbleSort() {
        int[] array = new int[]{14, 33, 27, 35, 10};

        SortingAlgorithms.bubbleSort(array);

        assertThat(array).containsExactly(10, 14, 27, 33, 35);
    }

    @Test
    void insertionSort() {
        int[] array = new int[]{14, 33, 27, 35, 10};

        SortingAlgorithms.insertionSort(array);

        assertThat(array).containsExactly(10, 14, 27, 33, 35);
    }

    @Test
    void mergeSort() {
        int[] array = new int[]{14, 33, 27, 35, 10};

        SortingAlgorithms.mergeSort(array);

        assertThat(array).containsExactly(10, 14, 27, 33, 35);
    }
}