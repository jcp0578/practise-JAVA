package increasingTriplet;

/*
 * 递增的三元子序列
 * https://leetcode-cn.com/explore/interview/card/top-interview-quesitons-in-2018/264/array/1133/
 * 
 * AC 
 * 
 */

public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int len=nums.length;
        if(len<3)
        	return false;
        int min_t1,min_t2;
        min_t1=nums[0];
        min_t2=Integer.MAX_VALUE;
        for(int i=1;i<len;i++)
        {
        	if(nums[i]<=min_t1)
        		min_t1=nums[i];
        	else
        	{
        		if(nums[i]>min_t2)
        			return true;
        		else 
        			min_t2=nums[i];
        	}
        }
        return false;
    }
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] num_in = {3,3,1,2,2,4};
		Solution test = new Solution();
		System.out.println(test.increasingTriplet(num_in));
		
	}

}
