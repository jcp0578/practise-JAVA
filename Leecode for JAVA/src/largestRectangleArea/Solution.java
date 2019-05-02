package largestRectangleArea;

/*
 * 柱状图中最大的矩形
 * AC but slow
 * 
 */
public class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights==null)
        	return 0;
        int len=heights.length;
        return deal(heights,0,len-1);
    }
	private int deal(int[] heights, int i, int j) {
		if(i==j)
			return heights[i];
		else if(i>j)
			return 0;
		else
		{
			int min_t=i;
			for(int k=i+1;k<=j;k++)
			{
				if(heights[k]<heights[min_t])
					min_t=k;
			}
			int temp=heights[min_t]*(j-i+1);
			temp=Math.max(temp, deal(heights,i,min_t-1));
			temp=Math.max(temp, deal(heights,min_t+1,j));
			return temp;
		}
		
	}
	public static void main(String[] args) {
		int[] test_in = { 4,2,0,3,2,4,3,4 };
		Solution test = new Solution();
		System.out.println(test.largestRectangleArea(test_in));

	}

}
