package longestConsecutive;

import java.util.HashMap;

/*
 * 最长连续序列
 * https://leetcode-cn.com/explore/interview/card/top-interview-quesitons-in-2018/272/dynamic-programming/1176/
 * 
 * 利用hashMap创建索引
 * AC but too slow
 */
public class Solution {
    public static int longestConsecutive(int[] nums) {
        int len=nums.length;
        if(len<=1)
        	return len;
    	HashMap<Integer,Integer> count=new HashMap<>();
        for(int num:nums)
        {
        	if(count.get(num)!=null)
        		continue;
        	Integer left_t=count.get(num+1);
        	Integer right_t=count.get(num-1);
        	if(left_t ==null && right_t==null)
        		count.put(num, 0);
        	else if((left_t==null ||left_t<0) && right_t!=null && right_t<=0 )//可扩展右边
        	{
        		count.put(num, right_t-1);
        		count.put(num+right_t-1, -right_t+1);
        	}
        	else if((right_t==null||right_t>0) && left_t!=null && left_t>=0)//可扩展左边
        	{
        		count.put(num, left_t+1);
        		count.put(num+left_t+1, -left_t-1);        		
        	}
        	else if(right_t!=null && left_t!=null)//两边都扩展
        	{
        		if(right_t<=0 && left_t>=0)
        		{
        			count.put(num, 0);
            		count.put(num+right_t-1, -right_t+left_t+2);
            		count.put(num+left_t+1, -left_t+right_t-2);
        		}
 
        	}
        }
        Integer out_t=-1;
        for(Integer temp:count.values())
        {
        	if(Math.abs(temp)>out_t)
        		out_t=temp;
        }
        return out_t+1;
    }
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] num_in= {2,-9,8,-2,0,9,-3,3,-4,5,-1,-3,5,2,8,-1,5,9,5};
		System.out.println(longestConsecutive(num_in));
	}

}
