public class ListExercise {
	//单链表反转 
	public ListNode reverse(ListNode head) {
		ListNode prev = null;
		ListNode cur = head;
		while(cur != null) {
			ListNode temp = cur.next;
			cur.next = prev;
			prev = cur;
			cur = temp;
		}
		return prev;
	}

	//链表中环的检测 leetcode linked-list-cycle 141
	public boolean hasCycle(ListNode head) {
		boolean result = true;
		if(head == null || head.next == null) return false;
		ListNode slow = head;
		ListNode fast = head.next;
		while(slow != fast) {
			if(fast == null || fast.next ==null) {
				result = false;
				break;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		return result;
	}

	//两个有序的链表合并  Leetcode 21.merge-two-sorted-lists
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)	return l2;
		if (l2 == null) return l1;
		ListNode head = new ListNode(0);
		ListNode cur = head;
		while(l1 != null && l2 != null) {
			if (l1.val<l2.val) {
				cur.next = l1;
				l1 = l1.next;
			}else {
				cur.next = l2;
				l2 = l2.next;
			}
            cur = cur.next;
		}
		if (l1 == null) cur.next = l2;
		if (l2 == null) cur.next = l1;
		return head.next;
		
	}

//	两个有序的链表合并，递归实现
	public ListNode mergeTwoListsByRecursion(ListNode l1, ListNode l2) {
		if (l1 == null)	return l2;
		if (l2 == null) return l1;
		if(l1.val<l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		}else {
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
		while(end != null) {
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
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	

}
