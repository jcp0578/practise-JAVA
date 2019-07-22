package isMatch.re;

/*
 * 正则表达式匹配
 * DP
 * 参考题解：https://blog.csdn.net/qq_41231926/article/details/82010888
 * 
 * AC
 * 9ms - 88.13%
 * 
 */
public class Solution {
	public boolean isMatch(String s, String p) {
		int len_s = s.length();
		int len_p = p.length();
		boolean[][] dp = new boolean[len_s + 1][len_p + 1];
		dp[0][0] = true;

		for (int x = 0; x < s.length() + 1; x++) {
			for (int y = 1; y < p.length() + 1; y++) {

				if (x > 0 && (p.charAt(y - 1) == '.' || p.charAt(y - 1) == s.charAt(x - 1))) {
					dp[x][y] = dp[x - 1][y - 1];
				}
				if (p.charAt(y - 1) == '*') {
					if (x == 0 || (s.charAt(x - 1) != p.charAt(y - 2) && p.charAt(y - 2) != '.')) {
						dp[x][y] = dp[x][y - 2];
					} else {
						dp[x][y] = dp[x - 1][y] || dp[x][y - 1] || dp[x][y - 2];
					}
				}
			}
		}
		return dp[len_s][len_p];
	}

	public static void main(String[] args) {
		String test_in1 = "aa";
		String test_in2 = "a";
		Solution test = new Solution();
		System.out.println(test.isMatch(test_in1, test_in2));
	}

}
