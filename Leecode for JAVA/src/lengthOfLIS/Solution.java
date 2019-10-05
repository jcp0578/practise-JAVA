package lengthOfLIS;

/*
 * title:300. 最长上升子序列
 * url:https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * time :13ms
 * memory: 36.4 MB
 * 
 * AC 
 * dp
 * 
 */

public class Solution {
	public int lengthOfLIS(int[] nums) {
		if (nums == null) {
			return 0;
		}
		int len = nums.length;
		int[] dp = new int[len];
		for (int i = 0; i < len; i++) {
			int temp = 1;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					temp = Math.max(dp[j] + 1, temp);
				}
			}
			dp[i] = temp;
		}
		int res = 0;
		for (int i = 0; i < len; i++) {
			if (dp[i] > res) {
				res = dp[i];
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] test_in = { 10, 9, 2, 5, 3, 7, 101, 18 };
		Solution test = new Solution();
		System.out.println(test.lengthOfLIS(test_in));

	}

}
