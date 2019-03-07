package rotateRight;

//import util.ListNode;

/*
 * https://leetcode-cn.com/problems/rotate-list/
   *   旋转链表
   *   双指针查找倒数第k个节点
  *   AC but too bad
 */
public class Solution {
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
    public ListNode rotateRight(ListNode head, int k) {
    	if(head==null)
    		return head;
    	ListNode node_shift=head,node_find=head;
    	for(int i=0;i<k;i++)
    	{
    		if(node_shift.next!=null)
    			node_shift=node_shift.next;
    		else
    			node_shift=head;
    	}
    	while(node_shift.next!=null)
    	{
    		node_shift=node_shift.next;
    		node_find=node_find.next;
    	}
    	node_shift.next=head;
    	head=node_find.next;
    	node_find.next=null;	
    	return head;
    }
    
}
