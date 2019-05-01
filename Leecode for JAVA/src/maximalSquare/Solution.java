package maximalSquare;

/*
 * 最大正方形
 * DP
 * dp[j][i] = Math.min(Math.min(dp[j - 1][i], dp[j][i - 1]), dp[i - 1][j - 1]) + 1;
 * 
 * AC
 * 10ms - 89.56%
 * 
 */
public class Solution {
	public int maximalSquare(char[][] matrix) {
		if (matrix == null)
			return 0;
		int len_r = matrix.length;
		if (len_r == 0)
			return 0;
		int len_l = matrix[0].length;
		if (len_l == 0)
			return 0;

		int res = 0;
		int[][] dp = new int[len_r][len_l];
		for (int j = 0; j < len_r; j++) {
			for (int i = 0; i < len_l; i++) {
				if (matrix[j][i] == '1') {
					if (j == 0 || i == 0)
						dp[j][i] = 1;
					else {
						dp[j][i] = Math.min(Math.min(dp[j - 1][i], dp[j][i - 1]), dp[j - 1][i - 1]) + 1;
					}
					if (dp[j][i] > res)
						res = dp[j][i];
				}
			}
		}
		return res * res;
	}

	public static void main(String[] args) {
		char[][] test_in = { { '0', '1', '1', '0', '1' }, { '1', '1', '0', '1', '0' } };
		Solution test = new Solution();
		System.out.println(test.maximalSquare(test_in));

	}

}
