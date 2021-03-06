package com.exercise.LinkedList;

public class ListExercise {
    //单链表反转
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    //链表中环的检测 leetcode linked-list-cycle 141
    public boolean hasCycle(ListNode head) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode slow = fakeHead;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            if (fast != slow) {
                fast = fast.next.next;
                slow = slow.next;
            } else {
                return true;
            }
        }
        return false;
    }

    //两个有序的链表合并 遍历实现 Leetcode 21.merge-two-sorted-lists
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode fakeHead = new ListNode(0);
        ListNode cur = fakeHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 == null) cur.next = l2;
        if (l2 == null) cur.next = l1;
        return fakeHead.next;

    }

    //	两个有序的链表合并，递归实现
    public ListNode mergeTwoListsByRecursion(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    //删除链表倒数第 n个结点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode end = new ListNode(0);
        end.next = head;
        ListNode ans = end;
        ListNode prev = end;
        for (int i = 0; i <= n; i++) {
            end = end.next;
        }
        while (end != null) {
            end = end.next;
            prev = prev.next;
        }
        prev.next = prev.next.next;
        return ans.next;
    }

    //求链表的中间结点(如果是偶数，返回中间两个中靠右的那个）
    public ListNode findCenter(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 反转其中一段链表
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode prev = fakeHead;
        ListNode cur = head;

        ListNode mNode;
        ListNode nNode;
        ListNode beforeM;
        ListNode afterN ;

        // 找到m和m前一个节点
        for(int i = 0; i < m - 1; i++) {
            cur = cur.next;
            prev = prev.next;
        }
        beforeM = prev;
        mNode = cur;

        // 从m开始反转链表，直到n
        for(int i = 0; i <= n - m; i++) {
            ListNode nextTemp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextTemp;
        }
        // 记录n和n的下一个节点
        nNode = prev;
        afterN = cur;

        beforeM.next = nNode;
        mNode.next = afterN;
        return fakeHead.next;
    }

}
