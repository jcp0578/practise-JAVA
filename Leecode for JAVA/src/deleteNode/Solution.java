package deleteNode;

import util.ListNode;

/*
 * 删除链表中的节点
 * https://leetcode-cn.com/explore/interview/card/top-interview-quesitons-in-2018/265/linked-list/1151/
 * 链表至少包含两个节点。
 * 链表中所有节点的值都是唯一的。
 * 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
 * 不要从你的函数中返回任何结果。
 * 
 * 将当前修改为下一个节点相关信息即可
 *
 * AC
 */
class Solution {
    public void deleteNode(ListNode node) {
    	ListNode next_p=node.next;   //非末尾节点无需检查
    	node.val=next_p.val;
    	node.next=next_p.next;
    	next_p.next=null;
    }
}
