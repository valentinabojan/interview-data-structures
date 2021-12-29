package org.example.stack;

public class StackWithArray implements Stack<Integer> {

    private int capacity = 1;
    private Integer[] elements = new Integer[capacity];
    private int size = 0;

    @Override
    public void push(Integer data) {
        if (size >= capacity) {
            capacity = capacity * 2;
            Integer[] newElements = new Integer[capacity];
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
        elements[size] = data;
        size++;
    }

    @Override
    public Integer pop() {
        Integer element = elements[size - 1];
        elements[size - 1] = null;
        size--;
        return element;
    }

    @Override
    public Integer peek() {
        return elements[size - 1];
    }

    @Override
    public String toString() {
        String str = "";
        for (Integer element : elements) {
            str += element + " ";
        }
        return str;
    }
}
