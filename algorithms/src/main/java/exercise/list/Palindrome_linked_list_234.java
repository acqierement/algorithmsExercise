package src.main.java.exercise.list;

public class Palindrome_linked_list_234 {
	public  boolean isPalindromeByReverse(ListNode head) {
        boolean result = true;
        if(head == null) return result;
        ListNode cur = copyListNode(head);
        ListNode reverseList = reverse(head);

        while(cur!=null){
            if(cur.val != reverseList.val){result = false;break;}
            else{
            	cur = cur.next;
                 reverseList = reverseList.next;}
        }
        return result ;
    }

	public boolean isPalindromeByFindCenter(ListNode head) {
		boolean result = true;
        if(head == null) return result;
		ListNode center = findCenter(head);
		ListNode reverse = reverse(center);
		while(reverse != null) {
			if (reverse.val != head.val) {
				result = false;
				break;
			}else {
				reverse = reverse.next;
				head = head.next;
			}
		}
		return result;
	}



	public ListNode findCenter(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while(fast!=null&&fast.next !=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public  ListNode copyListNode(ListNode head) {
        ListNode copy = new ListNode(0);
        ListNode cur =copy;

        while(head!=null){
            cur.next = new ListNode(head.val);
            cur = cur.next;
            head = head.next;
        }
        return copy.next;
	}

    public  ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head!= null){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}
