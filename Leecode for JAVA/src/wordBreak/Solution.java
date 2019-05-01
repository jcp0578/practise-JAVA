package wordBreak;

import java.util.ArrayList;
import java.util.List;

/*
 * 
 * 单词拆分
 * DP
 * 加入对字典最长的判断优化
 * AC but slow
 * 14ms 62.56%
 * 
 */
public class Solution {
	String _str;
	List<String> _dict;
	public boolean wordBreak(String s, List<String> wordDict) {
		this._str=s;
		this._dict=wordDict;
		int len=s.length();
		boolean[] flag=new boolean[len+1];
		flag[0]=true;
		
		int word_len_max=0;
		for(String t:_dict)
		{
			word_len_max=Math.max(word_len_max, t.length());
		}
		
		for(int i=1;i<=len;i++)
		{
			for(int j=Math.max(0, i-word_len_max);j<i;j++)
			{
				if(flag[j])
				{
					if(check(j,i))
						flag[i]=true;
				}
			}
		}
    	return flag[len];
    }
	private boolean check(int start,int end) {
		if(start>=end)
			return false;
		for(String t:_dict)
		{
			int i=0;
			int t_len=t.length();
			if((end-start)!=t_len)
				continue;
			for(i=0;i<t_len;i++)
			{

				if(t.charAt(i)!=_str.charAt(start+i))
				{
					break;
				}
			}
			if(i==t_len)
			{
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		String test_in="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		List<String> wordDict_t=new ArrayList<>();
		wordDict_t.add("a");
		wordDict_t.add("aa");
		wordDict_t.add("aaa");
		wordDict_t.add("aaaa");
		wordDict_t.add("aaaaa");
		wordDict_t.add("aaaaaa");
		wordDict_t.add("aaaaaaa");
		wordDict_t.add("aaaaaaaa");
		wordDict_t.add("aaaaaaaaa");
		wordDict_t.add("aaaaaaaaaa");
		wordDict_t.add("aaaaaaaaaaa");
		Solution test=new Solution();
		System.out.println(test.wordBreak(test_in, wordDict_t));

	}

}
