package numMatchingSubseq;

/*
 * titel:792. 匹配子序列的单词数
 * url:https://leetcode-cn.com/problems/number-of-matching-subsequences/submissions/
 * time:1698ms - 5.08%
 * memory:38.5MB - 97.22%
 * 
 * AC but too slow
 * 
 */
public class Solution {

	public int numMatchingSubseq(String S, String[] words) {
		int len = words.length;
		int res = 0;
		for (int i = 0; i < len; i++) {
			String temp = words[i];
			if (isSub(S, temp)) {
				res++;
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
