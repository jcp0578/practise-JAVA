package mergeKLists;

public class Solution2 {
	public ListNode mergeKLists(ListNode[] lists) {
		int list_len = lists.length;
		if(list_len==0)
		{
			return null;
		}
		int k = list_len;
		while (k > 1) {
			for (int i = 0; i < k / 2; i++) {
				lists[i] = mergeList(lists[i], lists[k - 1 - i]);
			}
			k = (k +1)/ 2;
		}
		return lists[0];
	}

	private ListNode mergeList(ListNode l1, ListNode l2) {
		ListNode root=new ListNode(0);
		root.next=null;
		ListNode node=root;
		while(l1!=null && l2!=null)
		{
			if(l1.val < l2.val)
			{
				node.next=l1;
				l1=l1.next;
				node.next.next=null;
				node=node.next;
			}
			else
			{
				node.next=l2;
				l2=l2.next;
				node.next.next=null;
				node=node.next;				
			}
		}
		if(l1==null)
		{
			node.next=l2;
		}
		else
		{
			node.next=l1;
		}		
		return root.next;
	}

}
