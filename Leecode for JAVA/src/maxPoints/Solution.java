package maxPoints;

/*
   *  直线上最多的点数
 * 
 * 
 * AC 20ms 90%
 * 
   * 选定两个点，遍历所有其他点，判断是否在同一直线上
   * 注意所有点为同一点的情况
 * 
 */

public class Solution {
    public int maxPoints(Point[] points) {
        int len=points.length;
        if(len<=2)
        	return len;
        int out_t=0;
        for(int i=0;i<len;i++)
        {
        	int same_point=1;
	    	for(int j=i+1;j<len;j++)
	    	{
	    		if((points[j].x==points[i].x)&& (points[j].y==points[i].y))
	    		{
	    			same_point++;
	    			continue;	
	    		}
	    		int max_t=2;
	    		for(int k=0;k<len;k++)
	    		{
		    		if(k==i || k==j)
		    			continue;
		    		long temp1=((long)points[k].x-points[j].x)*(points[k].y-points[i].y);
		    		long temp2=((long)points[k].x-points[i].x)*(points[k].y-points[j].y);
		    		if(temp1==temp2)
		    			max_t++;
	    		}
	    		out_t=Math.max(out_t, max_t);
	    	}
	    	if(same_point==len)
	    		return len;
        }
        return out_t;
    }
	public static void main(String[] args) {
		Point[] in = {new Point(1,1),new Point(1,1),new Point(3,3),new Point(94911152,94911151)};
		Solution test = new Solution();
		System.out.println(test.maxPoints(in));
	}

}
/**
 * Definition for a point.
 * */
class Point {
     int x;
     int y;
     Point() { x = 0; y = 0; }
     Point(int a, int b) { x = a; y = b; }
 }