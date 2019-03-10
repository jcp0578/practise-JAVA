package longestSubstring;

/*
 * 至少有K个重复字符的最长子串
 * https://leetcode-cn.com/explore/interview/card/top-interview-quesitons-in-2018/272/dynamic-programming/1174/
 * 
 * 建立统计，利用不可能的字符分割字符串，进行判断
 * 
 * AC 3ms 93.64%
 */
public class Solution {
	public static int longestSubstring(String s, int k) {
		return find(s,0,s.length()-1,k);
	}
	public static int find(String s, int start, int end,int k) {
		int len = (end-start);
		if (len < k)
			return 0;
		int[] count = new int[26];
		for (int i=start;i<end;i++) {
			count[s.charAt(i) - 'a']++;
		}
		int min_temp=Integer.MAX_VALUE;
		for(int i=0;i<26;i++)
		{
			if(count[i]!=0)
				min_temp=(min_temp<count[i])?min_temp:count[i];
		}
		if(min_temp!=Integer.MAX_VALUE && min_temp>=k)
		{
			return (end-start);
		}
		
		int i=start,j=start;
		int out=0;
		int flag=0;
		for(i=0;i<end;i++)
		{
			if(flag==0)
			{
				if(count[s.charAt(i) - 'a']>=k)
				{
					j=i;
					flag=1;
				}
			}
			else
			{
				if(count[s.charAt(i) - 'a']<k)
				{
					int temp=find(s,j,i,k);
					out=(out>temp)?out:temp;
					flag=0;
				}
			}
		}
		if(flag==1)
		{
			int temp=find(s,j,end,k);
			out=(out>temp)?out:temp;
		}
		return out;
	}	

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		String in_temp = "caaabbbbcc";
		int K = 3;
		System.out.println(longestSubstring(in_temp, K));
	}

}
