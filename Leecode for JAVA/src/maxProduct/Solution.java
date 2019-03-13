package maxProduct;


/*
 * 乘积最大子序列
 * https://leetcode-cn.com/explore/interview/card/top-interview-quesitons-in-2018/264/array/1126/
 * 
 * 穷举
 * 时间复杂度O(N^2)  空间复杂度O(N)
 * AC but too slow
 * 
 */
class Solution {
    public int maxProduct(int[] nums) {
        int len=nums.length;
        if(len==0)
        	return 0;
        else if(len==1)
        	return nums[0];
        int[] max_temp=new int[len];
        for(int i=0;i<len;i++)
        	max_temp[i]=nums[i];
        
        for(int i=0;i<len;i++)
        {
        	int Product_t=1;
        	for(int j=i;j<len;j++)
        	{
        		Product_t*=nums[j];
        		max_temp[j]=Math.max(Product_t, max_temp[j]);
        	}
        }
        int out_t=max_temp[0];
        for(int i=1;i<len;i++)
        	out_t=Math.max(max_temp[i], out_t);
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





