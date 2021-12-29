package org.example.minheap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinHeap {

    int[] elements = new int[20];
    int size = 0;

    public void push(int data) {
        if (size == 0) {
            elements[0] = data;
            size++;
            return;
        }

        int index = size;

        elements[index] = data;
        size++;

        int parentIdx = (index - 1) / 2;

        while (elements[parentIdx] > data) {
            int parent = elements[parentIdx];
            elements[parentIdx] = data;
            elements[index] = parent;
            index = parentIdx;
            parentIdx = (index - 1) / 2;
        }
    }

    public int peek() {
        return elements[0];
    }

    public int pop() {
        int minElement = elements[0];

        elements[0] = elements[size - 1];
        size--;

        int index = 0;
        int leftChildIdx = 2 * index + 1;
        int rightChildIdx = 2 * index + 2;

        while ((leftChildIdx < size && elements[index] > elements[leftChildIdx]) || (rightChildIdx < size && elements[index] > elements[rightChildIdx])) {
            int minIdx = leftChildIdx;
            if (rightChildIdx < size && elements[rightChildIdx] < elements[leftChildIdx]) {
                minIdx = rightChildIdx;
            }

            int min = elements[minIdx];
            elements[minIdx] = elements[index];
            elements[index] = min;

            index = minIdx;
            leftChildIdx = 2 * index + 1;
            rightChildIdx = 2 * index + 2;
        }


        return minElement;
    }

    public List<Integer> getHeap() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(elements[i]);
        }
        return list;
    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }
}
