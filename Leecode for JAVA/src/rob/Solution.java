package rob;

/*
 * 打家劫舍
 * https://leetcode-cn.com/explore/interview/card/top-interview-quesitons-in-2018/272/dynamic-programming/1177/
 * F(n)=max(F(n-1),p(n)+F(n-2))
 * 
 * AC 6ms
 * 时间复杂度O(N)  空间复杂度O(1),但是修改了原数据，不修改原数据，则空间复杂度O(N)
 */
public class Solution {
    public static int rob(int[] nums) {
    	int len=nums.length;
    	if(len<=0)
    		return 0;
    	else if(len==1)
    		return nums[0];
    	else if(len==2)
    		return Math.max(nums[0], nums[1]);
    	else
    	nums[1]=Math.max(nums[0], nums[1]);
    	for(int i=2;i<len;i++)
    	{
    		nums[i]=Math.max(nums[i]+nums[i-2],nums[i-1]);
    	}
		return nums[len-1];
    }
	public static void main(String[] args) {
		int[] num_in= {2,1,1,2};
		System.out.println(rob(num_in));

	}

}
