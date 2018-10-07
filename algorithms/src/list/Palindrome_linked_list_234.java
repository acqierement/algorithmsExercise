package list;

public class Palindrome_linked_list_234 {
	public static void main(String[] args) {
		ListNode listNode = new ListNode(1);
		ListNode se =new ListNode(1);
		
		listNode.next =se;
		
		listNode.next.next = new ListNode(2);
		listNode.next.next.next = new ListNode(1);
		listNode.next.next.next.next = new ListNode(1);
		listNode.next.next.next.next.next = null;
		boolean palindrome = isPalindrome(listNode);
		System.out.println(palindrome);


	}
	
	public static boolean isPalindrome(ListNode head) {
        boolean result = true;
        if(head == null) return result;
        ListNode cur = copyListNode(head);
        ListNode reverseList = reverse(head);
       
        while(cur!=null){
            if(cur.val != reverseList.val){result = false;break;}
            else{
            	System.out.println("cur.val: "+cur.val);
            	System.out.println("reverse.val: "+reverseList.val);
            	cur = cur.next;
                 reverseList = reverseList.next;}
        }
        
        return result ;
        
    }
	public static ListNode copyListNode(ListNode head) {
        ListNode copy = new ListNode(0);
        ListNode cur =copy;
      
        while(head!=null){
            cur.next = new ListNode(head.val);
            cur = cur.next;
         //   System.out.println(cur.val);
            head = head.next;
        }
        return copy.next;
	}
    public static ListNode reverse(ListNode head){
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
