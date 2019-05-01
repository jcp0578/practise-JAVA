package intersection;

/*
 * 两个数组的交集
 * AC but slow
 * 8ms - 52.24%
 * 
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TreeSet;

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
    	if(nums1==null || nums1.length==0)
    		return new int[0];
    	if(nums2==null || nums2.length==0)
    		return new int[0]; 
    	if(nums1.length>nums2.length)
    	{
    		int[] temp=nums1;
    		nums1=nums2;
    		nums2=temp;
    	}
        ArrayList<Integer> out=new ArrayList<>();
        HashSet<Integer> set=new HashSet<Integer>();
        for(int t:nums1)
        	set.add(t);
        for(int t:nums2)
        {
        	if(set.contains(t))
        	{
        		out.add(t);
        		set.remove(t);
        	}
        }
        int[] ret=new int[out.size()];
        for(int i=0;i<out.size();i++)
        	ret[i]=out.get(i);
        return ret;
    }
	public static void main(String[] args) {
		int[] test_in1= {4,9,5,10};
		int[] test_in2= {9,4,9,8,4,12};
		Solution test=new Solution();
		int[] res=test.intersection(test_in1, test_in2);
		for(int t:res)
			System.out.println(t);
	}

}
