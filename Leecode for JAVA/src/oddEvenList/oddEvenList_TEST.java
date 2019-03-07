package oddEvenList;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import util.ListNode;

class oddEvenList_TEST {

	void printListNode(ListNode head) {
		while (head != null) {
			System.out.print(head.val);
			head = head.next;
			System.out.print("->");
		}
		System.out.println("NULL");
	}

	Integer[] ListNodetoArrays(ListNode head) {
		List<Integer> out = new ArrayList<>();

		while (head != null) {
			out.add(head.val);
			head = head.next;

		}
		return out.toArray(new Integer[out.size()]);
	}

	ListNode generateListNode(int[] num_in) {
		ListNode in_head = new ListNode(-1);
		ListNode p_t = in_head;
		for (int num : num_in) {
			ListNode temp = new ListNode(num);
			p_t.next = temp;
			p_t = temp;
		}
		p_t.next = null;
		return in_head.next;
	}

	@SuppressWarnings("deprecation")
	@DisplayName("NULL TEST")
	@Test
	void NULL_test() {
		int[] num_in = {};
		Integer[] out = {};
		ListNode in_head = generateListNode(num_in);
		ListNode out_head = Solution.oddEvenList(in_head);
		printListNode(out_head);
		assertEquals(out, ListNodetoArrays(out_head));
	}

	@DisplayName("single TEST")
	@Test
	void single_test() {
		int[] num_in = { 1 };
		Integer[] out = { 1 };
		ListNode in_head = generateListNode(num_in);
		ListNode out_head = Solution.oddEvenList(in_head);
		printListNode(out_head);
		assertEquals(out, ListNodetoArrays(out_head));
	}

	@DisplayName("two TEST")
	@Test
	void two_test() {
		int[] num_in = { 1, 2 };
		Integer[] out = { 1, 2 };
		ListNode in_head = generateListNode(num_in);
		ListNode out_head = Solution.oddEvenList(in_head);
		printListNode(out_head);
		assertEquals(out, ListNodetoArrays(out_head));
	}

	@DisplayName("three TEST")
	@Test
	void three_test() {
		int[] num_in = { 1, 2, 3 };
		Integer[] out = { 1, 3, 2 };
		ListNode in_head = generateListNode(num_in);
		ListNode out_head = Solution.oddEvenList(in_head);
		printListNode(out_head);
		assertEquals(out, ListNodetoArrays(out_head));
	}

	@DisplayName("more TEST")
	@Test
	void more_test() {
		int[] num_in = { 1, 2, 3, 4, 5, 6 };
		Integer[] out = { 1, 3, 5, 2, 4, 6 };
		ListNode in_head = generateListNode(num_in);
		ListNode out_head = Solution.oddEvenList(in_head);
		printListNode(out_head);
		assertEquals(out, ListNodetoArrays(out_head));
	}
}
