package org.example.sorting;

public class SortingAlgorithms {

    public static void bubbleSort(int[] array) {
        boolean sorted = false;
        int n = array.length - 1;

        while (!sorted) {
            sorted = true;

            for (int i = 0; i < n; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;

                    sorted = false;
                }
            }

            n--;
        }
    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i;

            while (j > 0 && array[j - 1] > current) {
                array[j] = array[j - 1];
                j--;
            }

            array[j] = current;
        }
    }

    public static void mergeSort(int[] array) {
        mergeSortAux(array, 0, array.length - 1);
    }

    public static void mergeSortAux(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int middle = (left + right) / 2;

        mergeSortAux(array, left, middle);
        mergeSortAux(array, middle + 1, right);
        merge(array, left, middle, right);
    }

    private static void merge(int[] array, int left, int middle, int right) {
        int[] arr1 = new int[middle - left + 1];
        int[] arr2 = new int[right - middle];

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = array[i + left];
        }
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = array[i + middle + 1];
        }

        int i = 0, j = 0, k = left;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                array[k] = arr1[i];
                i++;
            } else {
                array[k] = arr2[j];
                j++;
            }
            k++;
        }

        while (i < arr1.length) {
            array[k] = arr1[i];
            i++;
            k++;
        }
        while (j < arr2.length) {
            array[k] = arr2[j];
            j++;
            k++;
        }
    }

}
