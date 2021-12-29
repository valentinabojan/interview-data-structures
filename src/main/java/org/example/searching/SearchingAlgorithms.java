package org.example.searching;

import java.util.Arrays;

public class SearchingAlgorithms {

    public static int binarySearch(int[] array, int element) {
        return binarySearchAux(array, element, 0, array.length - 1);
    }

    private static int binarySearchAux(int[] array, int element, int left, int right) {
        if (left > right) {
            if (right < 0) {
                return 0;
            }
            if (left > array.length - 1) {
                return -(array.length - 1);
            }
            return Math.abs(array[left] - element) < Math.abs(array[right] - element) ? -left : -right;
        }

        int middle = (left + right) / 2;

        if (element < array[middle]) {
            return binarySearchAux(array, element, left, middle - 1);
        } else if (element > array[middle]) {
            return binarySearchAux(array, element, middle + 1, right);
        } else {
            return middle;
        }
    }
}
