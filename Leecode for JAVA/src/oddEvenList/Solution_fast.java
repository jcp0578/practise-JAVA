package oddEvenList;

import util.ListNode;

public class Solution_fast {
	public ListNode oddEvenList(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode odd = head, even = head.next, evenHead = even;
		while (even != null && even.next != null) {
			odd.next = odd.next.next;
			odd = odd.next;
			even.next = even.next.next;
			even = even.next;
		}
		odd.next = evenHead;
		return head;
	}
}
