package printListFromTailToHead;

import java.util.ArrayList;

/*
 * 从尾到头打印链表
 * 
 * AC
 * 
 */

public class Soluiton {
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> out_t=new ArrayList<>();
		printList(out_t,listNode);
		return out_t;
	}

	private void printList(ArrayList<Integer> out, ListNode node) {
		if(node!=null)
		{
			printList(out,node.next);
			out.add(node.val);
		}
	}

}

class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}