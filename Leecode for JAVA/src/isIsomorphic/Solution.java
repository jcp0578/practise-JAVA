package isIsomorphic;

import java.util.HashMap;

/*
 * 同构字符串
 * 注意是所有字符，而非小写字符
 * AC but slow
 * 21ms - 57.79%
 */
public class Solution {
	public boolean isIsomorphic(String s, String t) {
		if (s == null || t == null) {
			return (s == t);
		}
		if (s.length() != t.length())
			return false;
		int len = s.length();

		HashMap<Character, Character> map = new HashMap<>();
		HashMap<Character, Boolean> use = new HashMap<>();

		for (int i = 0; i < len; i++) {
			if (!map.containsKey(s.charAt(i)))// 未映射
			{
				if (use.containsKey(t.charAt(i)))
					return false;
				else {
					map.put(s.charAt(i), t.charAt(i));
					use.put(t.charAt(i), true);
				}
			} else {
				if (map.get(s.charAt(i)) == t.charAt(i))
					continue;
				else
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String test_in1 = "43";
		String test_in2 = "32";
		Solution test = new Solution();
		System.out.println(test.isIsomorphic(test_in1, test_in2));
	}

}
