package wordBreak;

import java.util.ArrayList;
import java.util.List;

/*
 * 
 * 单词拆分
 * 
 * out time
 * 
 */
public class Solution {
    String _str;
    List<String> _dict;
	public boolean wordBreak(String s, List<String> wordDict) {
		this._str=s;
		this._dict=wordDict;
    	return check(0);
        
    }
	private boolean check(int start) {
		if(start==_str.length())
			return true;
		boolean right_flag=false;
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
				if(check(start+t_len))
					right_flag=true;
			}
		}
		return right_flag;
	}
	public static void main(String[] args) {
		String test_in="bb";
		List<String> wordDict_t=new ArrayList<>();
		wordDict_t.add("bbb");
		wordDict_t.add("dog");
		wordDict_t.add("sand");
		wordDict_t.add("cat");
		wordDict_t.add("code");
		Solution test=new Solution();
		System.out.println(test.wordBreak(test_in, wordDict_t));

	}

}
