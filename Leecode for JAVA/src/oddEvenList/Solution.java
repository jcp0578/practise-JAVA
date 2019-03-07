package oddEvenList;

import util.ListNode;

/*
 * 奇偶链表
 * https://leetcode-cn.com/explore/interview/card/top-interview-quesitons-in-2018/265/linked-list/1152/
 *
 * AC 6ms
 * https://leetcode-cn.com/submissions/detail/14073365/
 */
public class Solution {
	public static ListNode oddEvenList(ListNode head) {

		if (head == null)
			return null;
		if (head.next == null)
			return head;

		ListNode odd_head = head;
		ListNode odd_last = head;
		ListNode even_head = head.next;
		ListNode even_last = head.next;

		while (even_last != null && even_last.next != null) {
			ListNode temp = even_last.next;
			odd_last.next = temp;
			odd_last = odd_last.next;
			even_last.next = temp.next;
			even_last = even_last.next;
		}
		odd_last.next = even_head;
		return odd_head;
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] num_in = { 1, 2, 3, 4 };
		ListNode in_head = new ListNode(-1);
		ListNode p_t = in_head;
		for (int num : num_in) {
			ListNode temp = new ListNode(num);
			p_t.next = temp;
			p_t = temp;
		}
		p_t.next = null;

		ListNode out_head;
		out_head = oddEvenList(in_head.next);

		while (out_head != null) {
			System.out.print(out_head.val);
			out_head = out_head.next;
			System.out.print("->");
		}
		System.out.print("NULL");

	}

}
