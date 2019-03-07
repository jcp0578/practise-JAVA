package rotateRight;

/*
 * https://leetcode-cn.com/problems/rotate-list/
   *   旋转链表
   *   获取长度后移动节点
 */
public class Solution_2 {
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
    public ListNode rotateRight(ListNode head, int k) {
    	if(head==null ||k==0)
    		return head;
    	ListNode node_end=head,node_find=head;
    	int node_len;
    	for(node_len=1;;node_len++)
    	{
    		if(node_end.next!=null)
    			node_end=node_end.next;
    		else
    			break;
    	}
    	int k_t=(k%node_len);
    	if(k_t==0)
    		return head;
    	for(int i=1;i<node_len-k_t;i++)
    	{
    		node_find=node_find.next;
    	}
    	node_end.next=head;
    	head=node_find.next;
    	node_find.next=null;	
    	return head;
    }
    
}
