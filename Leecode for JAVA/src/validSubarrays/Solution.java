package validSubarrays;

/*
 * 4. 有效子数组的数目
 * AC but slow
 * 
 */
public class Solution {
    public int validSubarrays(int[] nums) {
        if(nums==null)
        	return 0;
        int len=nums.length;
        if(len <=1)
        	return len;
        int out=0;
        for(int i=0;i<len;i++)
        {
        	int j=i;
        	for(;j<len;j++)
        	{
        		if(nums[i]>nums[j])
        			break;
        	}
        	out+=(j-i);
        }
        return out;
    }
	public static void main(String[] args) {
			int[] test_in = {};
		
			Solution test = new Solution();
			System.out.println(test.validSubarrays(test_in));

		}

}
