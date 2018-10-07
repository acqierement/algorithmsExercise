package list;

public class RemoveNthFromEnd {
	public static void main(String[] args) {
		ListNode listNode = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 =new ListNode(3);
		ListNode listNode4 =new ListNode(4);
		listNode.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;
		listNode4.next = new ListNode(5);
		ListNode removeNthFromEnd = removeNthFromEnd(listNode,2);
		ListNode first = removeNthFromEnd;
		while (first != null) {
			System.out.println(first.val);
			first = first.next;
		
		}
	}
	    public static ListNode removeNthFromEnd(ListNode head, int n) {
	        ListNode dummy = new ListNode(0);
	        dummy.next =head;
	        int length = 0;
	        int lengthSubN=0;
	        ListNode first = head;
	        ListNode removeNode = dummy;
	        while(first != null){
	            length++;
	            lengthSubN = length - n;
	            if(lengthSubN > 0){ 
	                removeNode = removeNode.next;
	            }
	            first=first.next;
	        }
	        removeNode.next = removeNode.next.next;
	            return dummy.next;
	    }
	
	
}
