package numDistinct;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * title:不同的子序列
 * url:https://leetcode-cn.com/problems/distinct-subsequences/submissions/
 * time: 20ms - 43.77% 
 * memory:37.9MB - 27.74%
 * 
 * AC but slow
 * 
 * DP 
 * dp[i][j] - s[:i]中含有t[:j]的个数
 * 转移关系  dp[i][j] = dp[i-1][j] + dp[i-1][j-1]*(s[i]==t[j])
 * 
 */
public class Solution {
	public int numDistinct(String s, String t) {
		int lenOfS = s.length();
		int lenOfT = t.length();

		int[][] dp = new int[lenOfS + 1][lenOfT + 1];
		for (int i = 0; i <= lenOfS; i++) {
			dp[i][0] = 1;
		}
		for (int i = 1; i <= lenOfS; i++) {
			for (int j = 1; j <= lenOfT; j++) {
				dp[i][j] = dp[i - 1][j];
				if (s.charAt(i - 1) == t.charAt(j - 1))
					dp[i][j] += dp[i - 1][j - 1];
			}
		}
		return dp[lenOfS][lenOfT];
	}

	public static void main(String[] args) {
		String str_in = "";
		String str_in2 = "";
		Solution test = new Solution();
		System.out.println(test.numDistinct(str_in, str_in2));

	}

}
