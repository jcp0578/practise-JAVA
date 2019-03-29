package removeElement;

/*
 * 移除元素
 * AC 
 * 1ms 100%
 * 
 */

public class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums==null)
        	return 0;
    	int i=0,j=0;
        int len=nums.length;
        for(;i<len;i++)
        {
        	if(nums[i]!=val)
        		nums[j++]=nums[i];
        }
        return j;
    }
	public static void main(String[] args) {
		Solution test = new Solution();
		int[] test_in = {0,1,2,2,3,0,4,2};
		int test_val = 2;
		System.out.println(test.removeElement(test_in,test_val));
		
		for (int i = 0; i < test_in.length; i++) {
			System.out.print(test_in[i]);
			System.out.print(' ');
		}		

	}

}
