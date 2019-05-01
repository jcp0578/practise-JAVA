package wiggleSort;

import java.util.Arrays;

/*
   *   摆动排序 II
   *   排序后插入
 * 
 * AC
 * 7ms - 70.53%
 * 
   *  时间复杂度O(NlogN)  空间复杂度O(N)
 */
public class Solution {
    public void wiggleSort(int[] nums) {
        int len=nums.length;
        if(len<=1)
        	return;
        int[] temp=new int[len];
        for(int i=0;i<len;i++)
        	temp[i]=nums[i];
    	Arrays.sort(temp);
    	int index=len-1;
    	for(int i=1;i<len;i+=2)
    		nums[i]=temp[index--];
    	for(int i=0;i<len;i+=2)
    		nums[i]=temp[index--];   	
    	
    }
	public static void main(String[] args) {
		int[] test_in= {1, 3, 2, 2, 2, 1};
		Solution test=new Solution();
		test.wiggleSort(test_in);
		for(int t:test_in)
		{
			System.out.print(t);
			System.out.print(" ");
		}
		

	}

}
