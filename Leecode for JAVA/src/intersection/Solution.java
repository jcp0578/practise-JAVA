package intersection;

/*
 * 两个数组的交集
 * AC but slow
 * 14ms - 25.08%
 * 
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TreeSet;

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
    	if(nums1==null || nums1.length==0)
    		return new int[0];
    	if(nums2==null || nums2.length==0)
    		return new int[0];    	
        ArrayList<Integer> out=new ArrayList<>();
        TreeSet<Integer> set1=new TreeSet<Integer>();
        for(int t:nums1)
        	set1.add(t);
        TreeSet<Integer> set2=new TreeSet<Integer>();
        for(int t:nums2)
        	set2.add(t);
        Iterator<Integer> set1_iterator = set1.iterator();
        Iterator<Integer> set2_iterator = set2.iterator();
        Integer t1=new Integer(set1_iterator.next());
        Integer t2=new Integer(set2_iterator.next());
        while(true)
        {	
            try 
            {
            	if(t1.equals(t2))
            	{
            		out.add(t1);
            		t1=set1_iterator.next();
            		t2=set2_iterator.next();
            	}
            	else if(t1>t2)
            	{
            		t2=set2_iterator.next();
            	}
            	else
            	{
            		t1=set1_iterator.next();
            	}            	
            }
            catch(NoSuchElementException e)
            {
            	break;
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
