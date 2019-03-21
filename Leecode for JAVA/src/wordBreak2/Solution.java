package wordBreak2;

import java.util.ArrayList;
import java.util.List;

/*
 * 
 * 单词拆分2
 * 
 * DFS
 * 
 * out time
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
		check(0,add_t);
    	return out;
        
    }
	private void check(int start, ArrayList<String> add_t) {
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
					check(start+t_len,add_t);
					add_t.remove(add_t.size()-1);
				}
			}			
		}
	}
	public static void main(String[] args) {
		String test_in="catsanddog";
		List<String> wordDict_t=new ArrayList<>();
		wordDict_t.add("cat");
		wordDict_t.add("cats");
		wordDict_t.add("and");
		wordDict_t.add("sand");
		wordDict_t.add("dog");
		Solution test=new Solution();
		System.out.println(test.wordBreak(test_in, wordDict_t));

	}

}