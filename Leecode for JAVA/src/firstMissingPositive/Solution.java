package firstMissingPositive;

/*
 * 缺失的第一个正数
 * https://leetcode-cn.com/problems/first-missing-positive/
 * 
 * 遍历数组，将[1,len]范围内的值val放入索引val-1的位置
 * 
 * AC
 * 
 * 时间复杂度O(N)  空间复杂度O(1),但是修改了原数据，不修改原数据，则空间复杂度O(N)
 */
public class Solution {
    public static int firstMissingPositive(int[] nums) {
        int len=nums.length;
        if(len<=0)
        	return 1;
        int start=0;
        while(start<len)
        {
        	if(nums[start]<=0 || nums[start]>len)
        	{
        		nums[start]=-1;
        		start++;
        	}
        	else if(nums[start]!=start+1)
        	{
        		if(nums[nums[start]-1]==-1)
        		{
        			nums[nums[start]-1]=nums[start];
        			nums[start]=-1;
        			start++;
        		}
        		else if(nums[nums[start]-1]==nums[start])
        		{
        			nums[start]=-1;
        			start++;
        		}
        		else
        		{
        			int temp=nums[nums[start]-1];
        			nums[nums[start]-1]=nums[start];
        			nums[start]=temp;
        		}
        	}
        	else
        	{
        		start++;
        	}	
        }
        int i;
        for(i=0;i<len;i++)
        {
        	if(nums[i]==-1)
        		break;
        }
        return i+1;

    }
	public static void main(String[] args) {
		int[] nums_in= {2,2,2};
		System.out.println(firstMissingPositive(nums_in));
		
	}

}
