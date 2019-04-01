package isInterleave;

/*
 * 交错字符串
 * dp
 * AC
 * 
 */
public class Solution {

	public boolean isInterleave(String s1, String s2, String s3) {
		int len1 = s1.length();
		int len2 = s2.length();
		int len3 = s3.length();
		if (len3 != (len1 + len2))
			return false;

		int[][] dp = new int[len1 + 1][len2 + 1];
		dp[0][0] = 1;

		for (int i = 1; i < len1 + 1; i++) {
			if (s1.charAt(i - 1) == s3.charAt(i - 1))
				dp[i][0] = 1;
			else
				break;
		}
		for (int j = 1; j < len2 + 1; j++) {
			if (s2.charAt(j - 1) == s3.charAt(j - 1))
				dp[0][j] = 1;
			else
				break;
		}

		for (int i = 1; i < len1 + 1; i++) {
			for (int j = 1; j < len2 + 1; j++) {
				if (dp[i - 1][j] == 1) {
					if (s1.charAt(i - 1) == s3.charAt(i + j - 1))
						dp[i][j] = 1;
				}
				if (dp[i][j - 1] == 1) {
					if (s2.charAt(j - 1) == s3.charAt(i + j - 1))
						dp[i][j] = 1;
				}
			}
		}
		return (dp[len1][len2] == 1);
	}

	public static void main(String[] args) {
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		Solution test = new Solution();
		System.out.println(test.isInterleave(s1, s2, s3));

	}

}
