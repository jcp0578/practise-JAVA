package longestConsecutive;

import java.util.HashMap;

/*
 * 最长连续序列
 * https://leetcode-cn.com/explore/interview/card/top-interview-quesitons-in-2018/272/dynamic-programming/1176/
 * 
 * 利用hashMap创建索引
 * 简化代码
 * AC but too slow
 */
public class Solution {
    public static int longestConsecutive(int[] nums) {
        if(nums.length<=1)
        	return nums.length;
    	HashMap<Integer,Integer> count=new HashMap<>();
        for(int num:nums)
        {
        	if(count.get(num)!=null)
        		continue;
        	Integer left_t=count.getOrDefault(num-1,0);
        	Integer right_t=count.getOrDefault(num+1,0);
        	int len=left_t+right_t+1;
        	count.put(num, len);
        	count.put(num-left_t, len);
        	count.put(num+right_t, len);
        }
        Integer out_t=0;
        for(Integer temp:count.values())
        {
        	if(temp>out_t)
        		out_t=temp;
        }
        return out_t;
    }
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] num_in= {2,-9,8,-2,0,9,-3,3,-4,5,-1,-3,5,2,8,-1,5,9,5};
		System.out.println(longestConsecutive(num_in));
	}

}
