package removeDuplicates;

/*
 * 删除排序数组中的重复项 II
 * 
 * AC
 * 2ms - 91.59%
 * 
 */

public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums==null ||nums.length==0)
        	return 0;
        int len=nums.length;
        int index=1;
        int last_num=nums[0];
        int count=1;
        for(int i=1;i<len;i++)
        {
        	if(nums[i]==last_num)
        	{
        		count++;
        		if(count<=2)
        		{
        			nums[index++]=nums[i];
        		}
        	}
        	else
        	{
        		nums[index++]=nums[i];
        		last_num=nums[i];
        		count=1;
        	}
        }
        return index;
    }
	public static void main(String[] args) {
		int[] test_in= {0,0,1,1,1,1,2,3,3};
		Solution test=new Solution();
		System.out.println(test.removeDuplicates(test_in));
		for(int t:test_in)
		{
			System.out.print(t);
			System.out.print(' ');
		}
	}

}
