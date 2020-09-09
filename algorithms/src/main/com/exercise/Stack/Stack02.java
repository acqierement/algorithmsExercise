package com.exercise.Stack;

import java.util.LinkedList;
import java.util.List;

public class Stack02 {
    private ListNode head = null;

    public void push(int num) {
        ListNode newNode =  new ListNode(num);
        newNode.next = head;
        head = newNode;
    }

    public int pop() {
        int val = head.val;
        head = head.next;
        return val;
    }

    public int peek() {
        return head.val;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }

}
