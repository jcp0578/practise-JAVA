package kInversePairs;

/*
 * K个逆序对数组
 * DP
 * AC
 * 22ms - 100%
 * 
 */
public class Solution {
	public int kInversePairs(int n, int k) {
		if (n == 0)
			return 0;
		if (k == 0)
			return 1;

		int[][] dp = new int[n][k + 1];
		dp[0][0] = 1;
		for (int i = 1; i < n; i++) {
			int sum_t = 0;
			for (int j = 0; j < k + 1 && j <= (i + 1) * i / 2; j++) {
				sum_t += dp[i - 1][j];
				if (j > i) {
					sum_t -= dp[i - 1][j - i - 1];
					if (sum_t < 0)
						sum_t += 1000000007;
				}
				if (sum_t > 1000000007)
					sum_t %= 1000000007;
				dp[i][j] = sum_t;
			}
		}
		return dp[n - 1][k];
	}

	public static void main(String[] args) {
		int test_n = 3;
		int test_k = 3;
		Solution test = new Solution();
		System.out.println(test.kInversePairs(test_n, test_k));
	}

}
