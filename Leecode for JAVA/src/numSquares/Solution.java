package numSquares;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * 完全平方数
 * https://leetcode-cn.com/explore/interview/card/top-interview-quesitons-in-2018/272/dynamic-programming/1178/
 * 
 * AC but too slow
 * 
 * 395 ms
 * https://leetcode-cn.com/submissions/detail/13952175/
 * 
 * 
 */
public class Solution {
	private static Map<Integer,Integer> note;
	
	public static int numSquares(int n) {
		if (n <= 0)
			return 0;
		note=new HashMap<Integer,Integer>();
		note.put(0, 0);
		note.put(1, 1);
		
		int out_t=Integer.MAX_VALUE;
		int sub_num = (int) Math.sqrt((double) n);
		if(n==sub_num*sub_num)
			return 1;
		for(int i=sub_num;i>0;i--)
		{
			int out_temp=findnumSquares(n-i*i)+1;
			if(out_temp<out_t)
				out_t=out_temp;
		}
		return out_t;
	}

	private static int findnumSquares(int num) {
		int out_t=note.getOrDefault(num, -1);
		if(out_t!=-1)
			return out_t;
		
		int sub_num = (int) Math.sqrt((double) num);
		if(num==sub_num*sub_num)
		{
			note.put(num, 1);
			return 1;
		}
		out_t=Integer.MAX_VALUE;
		for(int i=sub_num;i>0;i--)
		{
			int out_temp=findnumSquares(num-i*i)+1;
			if(out_temp<out_t)
				out_t=out_temp;
		}
		note.put(num, out_t);
		return out_t;
	}

	public static void main(String[] args) {
		int nums_in = 13;
		System.out.println(numSquares(nums_in));
	}
}

/*
 * 可利用数组实现备忘录法 
 * 
 * 
 */

class Solution_2 {
    public int numSquares(int n) {
        if(n<=0)
            return 0;
        int[] cntPerfectSquares = new int[n+1];
        Arrays.fill(cntPerfectSquares,Integer.MAX_VALUE);
        cntPerfectSquares[0]=0;
        for(int i=0;i<=n;i++)
        {
            for(int j=1;j*j<=i;j++)
            {
                cntPerfectSquares[i]=Math.min(cntPerfectSquares[i],cntPerfectSquares[i-j*j]+1);
            }
        }
        return cntPerfectSquares[n];
    }
}

/*
 * 可利用数组实现备忘录法 
 * 
 * 
 */
