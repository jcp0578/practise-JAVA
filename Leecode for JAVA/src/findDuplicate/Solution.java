package findDuplicate;

/*
   *  寻找重复数
 * 
 * AC but too slow
   *  时间复杂度O(N^2)
 */
public class Solution {
    public int findDuplicate(int[] nums) {
        int len=nums.length;
        if(len<2)
        	return -1;
        if(len==2)
        	return nums[0];
        
        for(int i=0;i<len;i++)
        {
        	for(int j=i+1;j<len;j++)
        	{
        		if(nums[i]==nums[j])
        			return nums[i];
        	}
        }
        return nums[len-1];
    }
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] num_in= {1,2,4,2,2};
		Solution test=new Solution();
		System.out.println(test.findDuplicate(num_in));
	}

}
