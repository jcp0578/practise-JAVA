package detectCycle;

import util.ListNode;

/*
 * 142. 环形链表 II
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * 
 * 先通过快慢指针判断有无环
 * 在B点相遇说明有环
 * 后在起点A和B点同步走，相遇点即为入环的第一个节点
 * 
 * 入环前长度a,环长度b
 * a+(n-a)+b=2n   -> n=b  
 *  
 *  AC 1ms
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast=head,slow=head;
        try
        {
        	do
        	{
        		fast=fast.next.next;
        		slow=slow.next;
        	}while(fast!=slow);
        }
        catch(Exception e)
        {
        	return null;
        }
        fast=head;
        while(fast!=slow)
        {
    		fast=fast.next;
    		slow=slow.next;        	
        }
        return slow;
    }
}
