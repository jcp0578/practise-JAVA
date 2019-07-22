package isMatch;

/*
 * 通配符匹配
 * DP
 * dp[x][y]表示s[0...x-1]能否被p[0...y-1]匹配
 * 
 * 参考题解:https://blog.csdn.net/qq_41231926/article/details/82732623
 * 
 * AC
 * 47ms - 61.02%
 */
public class Solution {
	public boolean isMatch(String s, String p) {
		if (p == null) {
			if (s == null)
				return true;
			else
				return false;
		}
		if (s == null) {
			for (int i = 0; i < p.length(); i++) {
				if (p.charAt(i) != '*')
					return false;
			}
			return true;
		}

		int len_s = s.length();
		int len_p = p.length();
		boolean[][] dp = new boolean[len_s + 1][len_p + 1];
		dp[0][0] = true;


		for (int i = 1; i < len_p + 1; i++) {
			dp[0][i] = true;
			for (int j = 0; j <= i - 1; j++) {
				if(p.charAt(j) != '*') {
					dp[0][i] = false;
				}
			}
		}

		for (int y = 0; y < p.length(); y++) {
			for (int x = 0; x < s.length(); x++) {
				char ch_temp = p.charAt(y);
				if (ch_temp == '?') {
					dp[x + 1][y + 1] = dp[x][y];
				} else if (ch_temp == '*') {
					dp[x + 1][y + 1] = dp[x][y + 1] || dp[x + 1][y];
				} else {
					if (s.charAt(x) == ch_temp) {
						dp[x + 1][y + 1] = dp[x][y];
					}
				}
			}
		}
		return dp[len_s][len_p];
	}

	public static void main(String[] args) {
		String test_in1 = "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb";
		String test_in2 = "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb";
		Solution test = new Solution();
		System.out.println(test.isMatch(test_in1, test_in2));

	}

}
