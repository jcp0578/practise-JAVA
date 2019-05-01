package mySqrt;

/*
 * x 的平方根
 * 
 * AC
 * 7ms - 79.84%
 */

public class Solution {
    public int mySqrt(int x) {
    	if(x==0)
    		return 0;
    	else if(x==1)
    		return 1;
    	int l=1,r=x;
    	while(l<r)
    	{
    		long mid=((long)l+(long)r)/2;
    		long comp=mid*mid;
    		int mid_t=(int)mid;
    		if(comp==x)
    		{
    			return mid_t;
    		}
    		else if(comp<x)
    			l=mid_t+1;
    		else
    			r=mid_t;
    	}
    	return r-1;
    }
	public static void main(String[] args) {
		int test_in = 2147483647;
		Solution test = new Solution();
		System.out.println(test.mySqrt(test_in));
	}

}
