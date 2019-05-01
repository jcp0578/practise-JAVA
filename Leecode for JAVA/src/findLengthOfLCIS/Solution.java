package findLengthOfLCIS;

/*
 * 最长连续递增序列
 * AC
 * 2ms - 98.71%
 */
public class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums==null)
        	return 0;
        int len=nums.length;
        if(len<=1)
        	return len;
        int res=1;
        int temp=1;
        for(int i=1;i<len;i++)
        {
        	if(nums[i]>nums[i-1])
        		temp++;
        	else
        	{
        		res=(temp>res)?temp:res;
        		temp=1;
        	}
        }
        res=(temp>res)?temp:res;
        return res;
    }
	public static void main(String[] args) {
		int[] test_in = { 1,3,5,9};
		Solution test = new Solution();
		System.out.println(test.findLengthOfLCIS(test_in));

	}

}
