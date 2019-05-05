package isMatch;

/*
 * 通配符匹配
 * out time
 * 1708/1808
 * 
 */
public class Solution {
	public boolean isMatch(String s, String p) {
		return isMatch(s, p, 0, 0);
	}

	private boolean isMatch(String s, String p, int i, int j) {
		int nums=0;
		for(int k=j;k<p.length();k++)
		{
			if(p.charAt(k)=='*')
				nums++;
		}
		if((s.length()-i)<(p.length()-j-nums))
			return false;
		
		if (i >= s.length() || j >= p.length()) {
			if (i == s.length())
			{
				int next_char_index=j;
				while (next_char_index < p.length() && p.charAt(next_char_index) == '*')
					next_char_index++;
				if(next_char_index==p.length())
					return true;
				else
					return false;
			}
			else
				return false;
		}

		char temp = p.charAt(j);
		if (temp == '?') {
			return isMatch(s, p, i + 1, j + 1);
		} else if (temp == '*') {
			if (j == (p.length() - 1))
				return true;
			else {
				// 查找下一个非'?'字符
				int next_char_index = j + 1;
				while (next_char_index < p.length() && p.charAt(next_char_index) == '?')
					next_char_index++;

				int find_index = i + (next_char_index - j - 1);

				if (next_char_index == p.length()) {
					if (find_index <= s.length())
						return true;
					else
						return false;
				} else if (p.charAt(next_char_index) == '*')
					return isMatch(s, p, find_index, next_char_index);
				
				int find_end_index=next_char_index+1;
				while(find_end_index<p.length() && p.charAt(find_end_index)!='*' && p.charAt(find_end_index)!='?')
					find_end_index++;
				String find_str=p.substring(next_char_index, find_end_index);
				while (find_index < s.length()) {
					int temp_index = s.indexOf(find_str, find_index);
					if (temp_index == -1)
						return false;
					else {
						if (isMatch(s, p, temp_index, next_char_index))
							return true;
						else
						{
							find_index = temp_index + 1;
						}
					}
				}
				return false;
			}
		} else {
			if (temp == s.charAt(i))
				return isMatch(s, p, i + 1, j + 1);
			else
				return false;
		}
	}

	public static void main(String[] args) {
		String test_in1 = "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb";
		String test_in2 = "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb";
		Solution test = new Solution();
		System.out.println(test.isMatch(test_in1, test_in2));

	}

}
