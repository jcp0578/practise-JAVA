package addTwoNumbers;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry_flag=0;
        ListNode out=new ListNode(0);
        ListNode out_t=out;
        while(l1!=null || l2!=null)
        {
        	int val1=(l1==null)?0:l1.val;
        	int val2=(l2==null)?0:l2.val;
    		int add_Sum=val1+val2+carry_flag;
    		
    		carry_flag=add_Sum/10;
    		add_Sum=add_Sum%10;
    	
    		out_t.next=new ListNode(add_Sum);
    		out_t=out_t.next;
    		l1=(l1==null)?null:l1.next;
    		l2=(l2==null)?null:l2.next;
        }
        if(carry_flag!=0)
        {
        	out_t.next=new ListNode(carry_flag);
        	out_t=out_t.next;
        }
        out_t.next=null;
		return out.next;
    }
}