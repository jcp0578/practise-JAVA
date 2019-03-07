package sortList;

import util.ListNode;

/*
 * 148. 排序链表
 * https://leetcode-cn.com/problems/sort-list/
 * 
 * 参考归并排序，利用双指针分割链表
 * AC 6ms
 * https://leetcode-cn.com/submissions/detail/13853422/
 * 
 */
public class Slution {
	public ListNode sortList(ListNode head) {
		if (head == null)
			return head;
		if (head.next == null)
			return head;
		
		//分割链表
		ListNode fast = head.next, slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		fast = slow.next; // 后一半的头节点
		slow.next = null;
		slow = head;
		
		ListNode out_l, out_r;
		out_l = sortList(fast);
		out_r = sortList(slow);
		
		//合并链表
		ListNode out_head, out_t;
		out_head = new ListNode(-1);
		out_head.next = null;
		out_t = out_head;
		while (out_l != null && out_r != null) {
			if (out_l.val < out_r.val) {
				out_t.next = out_l;
				out_l = out_l.next;
				out_t = out_t.next;
				out_t.next = null;
			} else {
				out_t.next = out_r;
				out_r = out_r.next;
				out_t = out_t.next;
				out_t.next = null;
			}
		}
		out_t.next = (out_l == null) ? out_r : out_l;
		return out_head.next;

	}
}
