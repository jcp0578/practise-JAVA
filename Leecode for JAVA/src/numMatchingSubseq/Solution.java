package numMatchingSubseq;

import java.util.HashMap;

/*
 * titel:792. 匹配子序列的单词数
 * url:https://leetcode-cn.com/problems/number-of-matching-subsequences/submissions/
 * time:41ms - 98.87%
 * memory:38.4MB - 97.22%
 * 
 * add map
 * AC
 * 
 */
public class Solution {

	public int numMatchingSubseq(String S, String[] words) {
		int len = words.length;
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < len; i++) {
			String temp = words[i];
			if (!map.containsKey(temp)) {
				map.put(temp, 1);
			} else {
				map.put(temp, map.get(temp) + 1);
			}
		}
		int res = 0;
		for (String key : map.keySet()) {
			if (isSub(S, key)) {
				res += map.get(key);
			}
		}
		return res;
	}

	private boolean isSub(String s, String temp) {
		if (s == temp)
			return true;
		int len1 = s.length();
		int len2 = temp.length();
		if (len2 > len1)
			return false;
		int i = 0, j = 0;
		for (i = 0; i < len1; i++) {
			if (s.charAt(i) == temp.charAt(j))
				j++;
			if (j == len2)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		String test_in = "abcde";
		String[] test_in2 = { "a", "bb", "acd", "ace" };
		Solution test = new Solution();
		System.out.println(test.numMatchingSubseq(test_in, test_in2));

	}

}
