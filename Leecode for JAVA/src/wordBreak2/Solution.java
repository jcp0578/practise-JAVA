package wordBreak2;

import java.util.ArrayList;
import java.util.List;

/*
 * 
 * 单词拆分2
 * 
 * DP判断是否存在，DSF输出
 * 
 * AC but slow
 * 33ms - 31.67%
 * 
 */
public class Solution {
    String _str;
    List<String> _dict;
    List<String> out;
    public List<String> wordBreak(String s, List<String> wordDict) {
		this._str=s;
		this._dict=wordDict;
		this.out=new ArrayList<String>();
		ArrayList<String> add_t=new ArrayList<>();
		
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
    	if(flag[len])
    		DSF(0,add_t);
    	return out;
        
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
	private void DSF(int start, ArrayList<String> add_t) {
		if(start==_str.length())
		{
			if(add_t.isEmpty())
			{
				
			}
			else
			{
				StringBuffer temp=new StringBuffer();
				for(String t:add_t)
				{
					temp.append(t);
					temp.append(" ");
				}
				temp.deleteCharAt(temp.length()-1);
				out.add(temp.toString());
			}

		}
		else
		{
			for(String t:_dict)
			{
				int i=0;
				int t_len=t.length();
				if((_str.length()-start)<t_len)
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
					add_t.add(t);
					DSF(start+t_len,add_t);
					add_t.remove(add_t.size()-1);
				}
			}			
		}
	}
	public static void main(String[] args) {
		String test_in="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
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
		Solution test=new Solution();
		System.out.println(test.wordBreak(test_in, wordDict_t));

	}

}