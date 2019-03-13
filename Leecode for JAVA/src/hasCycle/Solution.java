package hasCycle;

import util.ListNode;
/*
 * 环形链表
 * https://leetcode-cn.com/explore/interview/card/top-interview-quesitons-in-2018/265/linked-list/1146/
 * AC 1ms
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null)
            return false;
        if(head.next==null)
            return false;
        ListNode fast=head.next.next,slow=head.next;
        while(fast!=null &&fast.next!=null)
        {
            if(fast==slow)
                return true;
            else
            {
                fast=fast.next.next;
                slow=slow.next;
            }
        }
        return false;
    }
}
