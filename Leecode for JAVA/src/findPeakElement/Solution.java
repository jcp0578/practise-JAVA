package findPeakElement;

/*
 *  寻找峰值
 * AC but O(N)
 * 
 */
public class Solution {
    public int findPeakElement(int[] nums) {
        int len=nums.length;
        if(len<=1)
            return len-1;
        if(nums[0]>nums[1])
            return 0;
        for(int i=1;i<len-1;i++)
        {
            if(nums[i]>nums[i+1])
                return i;
        }
        return len-1;
    }
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] nums_in= {1,2,3,1};
		Solution test=new Solution();
		System.out.println(test.findPeakElement(nums_in));
	}

}
