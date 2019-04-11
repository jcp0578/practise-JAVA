package splitArray;

/*
 * 分割数组的最大值
 * DP
 * DP[i][j] 表示索引0~i分(j+1)组的最大值
 * 
 * DP[i][j]=min( max(DP[k][j-1],sum(nums[k+1]...nums[i]){j<k<i})
 * AC but slow
 * 23ms - 7.32%
 * 
 */
public class Solution {
	public int splitArray(int[] nums, int m) {
		if (nums == null)
			return 0;
		int len = nums.length;
		int[][] dp = new int[len][m];
		int sum = 0;
		for (int i = 0; i < len; i++) {
			sum += nums[i];
			dp[i][0] = sum;
		}
		for (int j = 1; j < m; j++) {
			for (int i = j; i < len; i++) {
				int min_t = Integer.MAX_VALUE;
				int back_sum_t = 0;
				for (int k = i - 1; k >= (j - 1); k--) {
					back_sum_t += nums[k + 1];
					int temp;
					if (dp[k][j - 1] >= back_sum_t) {
						temp = dp[k][j - 1];
						if (temp < min_t)
							min_t = temp;
					} else {
						temp = back_sum_t;
						if (temp < min_t)
							min_t = temp;
						break;
					}
				}
				dp[i][j] = min_t;
			}
		}
		return dp[len - 1][m - 1];
	}

	public static void main(String[] args) {
		int[] test_in = { 7, 2, 5, 10, 8 };
		int test_m = 2;
		Solution test = new Solution();
		System.out.println(test.splitArray(test_in, test_m));
	}

}
