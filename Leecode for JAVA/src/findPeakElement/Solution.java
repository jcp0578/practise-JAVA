package findPeakElement;

/*
 *    寻找峰值
 * AC
 * 
 */
public class Solution {
    public int findPeakElement(int[] nums) {
        int len=nums.length;
        if(len<=1)
            return len-1;
        int left=0,right=len-1;
        int mid=(left+right)/2;
        while(left<right)
        {
        	
        	if(nums[mid]>nums[mid+1])
        	{
        		right=mid;
        	}
        	else
        	{
        		left=mid+1;
        	}
        	mid=(left+right)/2;
        }
        return mid;
    }
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] nums_in= {0,1,2};
		Solution test=new Solution();
		System.out.println(test.findPeakElement(nums_in));
	}

}
