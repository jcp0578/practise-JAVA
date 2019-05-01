package maxEnvelopes;

/*
 * 俄罗斯套娃信封问题
 * 排序后查找
 * 时间复杂度O(N^2)
 * AC but too slow
 * 652ms - 15.71%
 * 
 */
import java.util.Arrays;

public class Solution {
	public int maxEnvelopes(int[][] envelopes) {
		if (envelopes == null)
			return 0;
		int len = envelopes.length;
		if (len <= 1)
			return len;
		int[] dp = new int[len];
		Arrays.fill(dp, 1);
		Arrays.sort(envelopes, (a, b) -> ((a == b) ? a[1] - b[1] : a[0] - b[0]));
		for (int i = 0; i < len; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (envelopes[i][1] > envelopes[j][1] && envelopes[i][0] > envelopes[j][0]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		int res = 1;
		for (int i = 0; i < len; i++) {
			if (dp[i] > res)
				res = dp[i];
		}
		return res;
	}

	public static void main(String[] args) {
		int[][] test_in = { { 5, 4 }, { 6, 4 }, { 6, 7 }, { 2, 3 } };
		Solution test = new Solution();
		System.out.println(test.maxEnvelopes(test_in));

	}

}