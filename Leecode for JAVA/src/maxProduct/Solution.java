package maxProduct;


/*
 * 乘积最大子序列
 * https://leetcode-cn.com/explore/interview/card/top-interview-quesitons-in-2018/264/array/1126/
 * 
 * 记录之前的最大值，最小值
 * 时间复杂度O(N)  空间复杂度(1)
 * AC 3ms
 * 
 */
class Solution {
    public int maxProduct(int[] nums) {
        int len=nums.length;
        if(len==0)
        	return 0;
        else if(len==1)
        	return nums[0];
        
        int max_temp=nums[0],min_temp=nums[0];
        int out_t=nums[0];
        for(int i=1;i<len;i++)
        {
        	int max_t=max_temp,min_t=min_temp;
        	if(nums[i]==0)
        	{
        		max_temp=0;
        		min_temp=0;
        	}
        	else if(nums[i] >0)
        	{
        		max_temp=Math.max(max_t*nums[i], nums[i]);
        		min_temp=Math.min(min_t*nums[i], nums[i]);
        	}
        	else
        	{
        		max_temp=Math.max(min_t*nums[i], nums[i]);
        		min_temp=Math.min(max_t*nums[i], nums[i]);        		
        	}
        	out_t=Math.max(out_t, max_temp);
        }
        return out_t;
    }
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] num_in= {2,-5,-2,-4,3};
		Solution test=new Solution();
		System.out.println(test.maxProduct(num_in));
		for(int t:num_in)
		{
			System.out.print(t);
			System.out.print(" ");
		}
		System.out.print('\n');
	}

}





