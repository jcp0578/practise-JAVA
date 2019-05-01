package maxCoins;

/*
 * 戳气球
 * DP
 * dp[i][j] 表示从i到j的最大值
 * 参考题解：https://blog.csdn.net/whdAlive/article/details/81153963
 * 
 * AC but slow
 * 23ms - 25.70%
 * 
 */
public class Solution {
	public int maxCoins(int[] nums) {
		if (nums == null)
			return 0;
		int len = nums.length + 2;
		if (len == 0)
			return 0;

		int[] coins = new int[len];
		for (int i = 0; i < len - 2; i++)
			coins[i + 1] = nums[i];
		coins[0] = 1;
		coins[len - 1] = 1;

		int[][] dp = new int[len][len];
		return deal(coins, dp, 0, len - 1);

	}

	private int deal(int[] coins, int[][] dp, int i, int j) {
		if ((i + 2) > j)
			return 0;
		if (dp[i][j] != 0)
			return (dp[i][j] == -1) ? 0 : dp[i][j];

		int res = 0;
		if ((i + 2) == j) {
			res = coins[i] * coins[i + 1] * coins[i + 2];
		} else {
			res = 0;
			for (int k = i + 1; k < j; k++) {
				int temp = 0;
				temp = deal(coins, dp, i, k) + deal(coins, dp, k, j) + coins[i] * coins[k] * coins[j];
				if (temp > res)
					res = temp;
			}

		}
		if (res == 0)
			dp[i][j] = -1;
		else
			dp[i][j] = res;
		return res;
	}

	public static void main(String[] args) {
		int[] test_in = { 3, 1, 5, 8 };
		Solution test = new Solution();
		System.out.println(test.maxCoins(test_in));

	}

}
