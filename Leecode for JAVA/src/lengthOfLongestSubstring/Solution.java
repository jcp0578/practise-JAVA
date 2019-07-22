package lengthOfLongestSubstring;

import java.util.HashMap;

/*
 * title:无重复字符的最长子串
 * https://leetcode-cn.com/submissions/detail/23645663/
 * 25 ms - 70.28%
 * 
 */
public class Solution {

	public int lengthOfLongestSubstring(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		int left = -1;
		int ret = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			left = Math.max(map.getOrDefault(c, -1), left);
			map.put(c, i);
			ret = Math.max(ret, (i - left));
		}

		return ret;
	}

	public static void main(String[] args) {
		String test_in = "pwwkew";
		Solution test = new Solution();
		System.out.println(test.lengthOfLongestSubstring(test_in));

	}

}
