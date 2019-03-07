package threeSumClosest;

import java.util.Arrays;
/*
 * AC 
 * 24ms
 * but use too much Memory
 */
public class Solution {
    public static int threeSumClosest(int[] nums, int target) {
    	int len=nums.length;
    	if(len<3)
    		return 0;
    	int out_t=target-nums[0]-nums[1]-nums[2];
    	Arrays.sort(nums);
    	for(int i=0;i<(len-2);i++)
    	{
    		if(i>0 && nums[i]==nums[i-1])
	    		continue;
    		int l=i+1,r=len-1;
    		int target_t=target-nums[i];
    		while(l<r)
    		{
    			int diff_temp=target_t-(nums[l]+nums[r]);
    			
    			if(diff_temp==0)
    				return target;
    			else if(diff_temp >0)
    			{
    				while(l<(r-1) && nums[l+1]==nums[l])
    					l++;
    				l++;		
    			}
    			else
    			{
    				while((l+1)<(r) && nums[r-1]==nums[r])
    					r--;
    				r--;
    			}
    			if(Math.abs(diff_temp) <Math.abs(out_t))
    				out_t=diff_temp;
    		}
    	}
		return (target-out_t);       
    }
	public static void main(String[] args) {
		int[] num_in= {1,2,3,-5,8,-1,10};
		int target=1;
		System.out.println(threeSumClosest(num_in,target));
	}
}
