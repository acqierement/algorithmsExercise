package com.exercise.Stack;

import java.util.Arrays;
import java.util.Stack;

public class Stack01 {
    private int[] arrayStack = new int[5];
    int size = 0;

    private void ensureCapacity(int size) {
        int len = arrayStack.length;
        if (size > len) {
            int newLen = len * 3 / 2 + 1;
            arrayStack = Arrays.copyOf(arrayStack, newLen);
        }
    }

    public void push(int num) {
        ensureCapacity(size + 1);
        arrayStack[size++] = num;
    }

    public int pop() {

        return arrayStack[--size];
    }

    public int peek() {
        return arrayStack[size - 1];
    }
}
