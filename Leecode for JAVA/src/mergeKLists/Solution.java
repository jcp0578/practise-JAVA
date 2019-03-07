package mergeKLists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> nums=new ArrayList<Integer>();
    	for(int i=0;i<lists.length;i++)
    	{
    		while(lists[i]!=null)
    		{
    			nums.add(lists[i].val);
    			lists[i]=lists[i].next;
    		}
    	}
    	Integer[] nums_array=(Integer[])nums.toArray(new Integer[nums.size()]);
    	
    	Arrays.sort(nums_array);
    	ListNode out=new ListNode(0);
    	out.next=null;
    	ListNode out_t=out;
    	for(int num:nums_array)
    	{
    		out_t.next=new ListNode(num);
    		out_t=out_t.next;
    	}
    	return out.next;
    }
}
