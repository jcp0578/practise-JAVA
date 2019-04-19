package minimumTotal;

import java.util.ArrayList;
import java.util.List;

/*
 * 三角形最小路径和
 * DP
 * AC
 * 7ms - 69.56%
 * 空间复杂度 O(n) （n 为三角形的总行数）
 * 
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null)
        	return 0;
    	int len=triangle.size();
    	if(len==0)
    		return 0;
    	
    	int[] dp=new int[len];
    	int[] now_val=new int[len];
    	for(int i=0;i<len;i++)
    	{
    		for(int j=0;j<triangle.get(i).size();j++)
    		{
    			if(j==0)
    				now_val[j]=triangle.get(i).get(j)+dp[j];
    			else if(j==triangle.get(i).size()-1)
    				now_val[j]=triangle.get(i).get(j)+dp[j-1];
    			else
    			{
    				now_val[j]=triangle.get(i).get(j)+Math.min(dp[j-1],dp[j]);
    			}
    		}
    		int[] temp;
    		temp=now_val;
    		now_val=dp;
    		dp=temp;
    	}
    	int res=dp[0];
    	for(int i=1;i<len;i++)
    	{
    		res=(dp[i]<res)?dp[i]:res;
    	}
    	return res;
    }
	public static void main(String[] args) {
		List<List<Integer>> test_in = new ArrayList<List<Integer>>();
		test_in.add(new ArrayList<>());
		test_in.get(0).add(2);
		test_in.add(new ArrayList<>());
		test_in.get(1).add(3);
		test_in.get(1).add(4);
		test_in.add(new ArrayList<>());
		test_in.get(2).add(6);
		test_in.get(2).add(5);
		test_in.get(2).add(7);
		test_in.add(new ArrayList<>());
		test_in.get(3).add(4);
		test_in.get(3).add(1);
		test_in.get(3).add(8);
		test_in.get(3).add(3);
		
		Solution test = new Solution();
		System.out.println(test.minimumTotal(test_in));
	}

}
