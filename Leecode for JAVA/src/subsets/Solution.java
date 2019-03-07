package subsets;
/*
 * 78. 子集
 * https://leetcode-cn.com/problems/subsets/
 * AC 2ms
 * https://leetcode-cn.com/submissions/detail/13822139/
 */
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<List<Integer>> subsets(int[] nums) {
    	List<List<Integer>> out_t=new ArrayList<List<Integer>>();
    	out_t.add(new ArrayList<Integer>());
    	for(int num:nums)
    	{
    		ArrayList<List<Integer>> list_temp=new ArrayList<List<Integer>>();
    		for(List<Integer> temp:out_t)
    		{
    			List<Integer> add_temp=new ArrayList<Integer>(temp);
    			list_temp.add(add_temp);
    		}
    		for(int i=0;i<list_temp.size();i++)
    		{
    			list_temp.get(i).add(num);
    			out_t.add(list_temp.get(i));
    		}
    	}	
		return out_t;
    }
	public static void main(String[] args) {
		int[] nums_in= {1,2,3};
		System.out.println(subsets(nums_in));
	}
}
