package org.example.searching;

import org.example.sorting.SortingAlgorithms;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.searching.SearchingAlgorithms.binarySearch;

class SearchingAlgorithmsTest {

    @Test
    void bubbleSort() {
        int[] array = new int[]{1, 2, 5, 6, 8, 10};

//        assertThat(binarySearch(array, 8)).isEqualTo(4);
//        assertThat(binarySearch(array, 9)).isEqualTo(-1);

        assertThat(binarySearch(array, 8)).isEqualTo(4);
        assertThat(binarySearch(array, 9)).isEqualTo(-4);
        assertThat(binarySearch(array, 0)).isEqualTo(0);
        assertThat(binarySearch(array, 11)).isEqualTo(-5);
        assertThat(binarySearch(array, 20)).isEqualTo(-5);
    }

}