package maxArea;

public class Solution {
	
    public int maxArea(int[] height) {
        
        int left_t=0,right_t=height.length-1;
        int max_temp=0;
        while(left_t<right_t)
        {
        	int area_temp=(right_t-left_t)*min(height[right_t],height[left_t]);
        	if(area_temp>max_temp)
        		max_temp=area_temp;
        	if(height[right_t] > height[left_t])
        	{
        		left_t=left_t+1;
        	}
        	else if(height[right_t] < height[left_t])
        	{
        		right_t=right_t-1;
        	}
        	else
        	{
        		if(height[right_t-1]>height[left_t+1])
        		{
        			right_t=right_t-1;
        		}
        		else
        		{
        			left_t=left_t+1;
        		}
        	}	
        }
        return max_temp;
        
    }

	private int min(int i, int j) {
		if(i > j)
			return j;
		return i;
	}
    
}