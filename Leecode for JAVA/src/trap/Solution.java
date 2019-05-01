package trap;

/*
 * 接雨水
 * 判断当前是否为剩下数中的最大值
 * 若为最大值，访问累加至次大值
 * 若不为最大值，访问累加至第一个比当前值大的值
 * AC
 * 7ms - 72.70%
 * 
 */
public class Solution {
    public int trap(int[] height) {
        if(height==null)
        	return 0;
        int len=height.length;
        if(len<=0)
        	return len;

        int left=0;
        int res=0;
        while(left<(len-2))
        {
        	int max_t,second_max;
        	if(height[left]>height[left+1])
        	{
        		max_t=left;
        		second_max=left+1;
        	}
        	else
        	{
        		max_t=left+1;
        		second_max=left;
        	}
        	for(int i=left+2;i<len;i++)
        	{
        		if(height[i]>height[max_t])
        		{
        			second_max=max_t;
        			max_t=i;
        		}
        		else if(height[i]>height[second_max])
        		{
        			second_max=i;
        		}
        	}
        	
        	if(left!=max_t)
        	{
        		int temp_index=left+1;
        		while(height[temp_index]<height[left])
        			temp_index++;
        		int edge=Math.min(height[left], height[temp_index]);
        		for(int i=left+1;i<temp_index;i++)
        		{
        			res+=(edge- height[i]);
        		}
        		left=temp_index;
        	}
        	else
        	{
        		int edge=height[second_max];
        		for(int i=left+1;i<second_max;i++)
        		{
        			res+=(edge- height[i]);
        		}
        		left=second_max;
        	}
        }
        return res;
    }
	public static void main(String[] args) {
		int[] test_in = {3,1,1,2,3,2,3};
		Solution test = new Solution();
		System.out.println(test.trap(test_in));

	}

}
