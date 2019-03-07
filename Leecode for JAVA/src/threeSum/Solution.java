package threeSum;

import java.util.*;

/*
 * AC but too slow
 */
class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
    	Arrays.sort(nums);
    	List<List<Integer>> list_out=new ArrayList<List<Integer>>();
    	
    	int nums_len=nums.length;
    	int[] opposite_list=new int[nums_len];
    	for(int i=0;i<nums_len;i++)
    	{
    		opposite_list[i]=(nums[i]*-1);
    	}
    	int last_num=0;
    	for(int i=0;i<nums_len;i++)
    	{
    		if(i!=0 && nums[i]==last_num)
    		{
    			continue;
    		}
    		int last_num_j=0;
    		for(int j=i+1;j<nums_len;j++)
    		{
        		if(j!=i+1 && nums[j]==last_num_j)
        		{
        			continue;
        		}
    			int sum_temp=nums[i]+nums[j];
    			
    			int find_l=j+1,find_r=nums_len-1;
    			while(find_l<=find_r)
    			{
    				int find_t=(find_l+find_r)/2;
    				int find_num=opposite_list[find_t];
    				if(find_num==sum_temp)
    				{
    					list_out.add(Arrays.asList(nums[i],nums[j], nums[find_t]));
    					break;
    				}
    				else if(find_num >sum_temp)
    				{
    					find_l=find_t+1;
    				}
    				else
    				{
    					find_r=find_t-1;
    				}
    			}
    			last_num_j=nums[j];
    		}
    		last_num=nums[i];
    	}
    	return list_out;
    }
    
	public static void main(String[] args) {
		int[] num_in= {-1, 0, 0,0,1,0,1, 2, -1, -4};
		System.out.println(threeSum(num_in));
	}
}
