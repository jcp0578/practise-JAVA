package canJump;

/*
 * 跳跃游戏
 * AC
 * 5ms - 60.53%
 * 
 */
public class Solution {
	public boolean canJump(int[] nums) {
		if (nums == null)
			return false;
		int len = nums.length;
		if(len<=1)
			return true;
		int[] dp = new int[len];
		dp[0] = nums[0];
		for (int i = 1; i < len; i++) {
			if (dp[i - 1] >= i)
				dp[i] = Math.max(dp[i - 1], i + nums[i]);
			else
				dp[i] = dp[i - 1];
		}
		return (dp[len - 1] >= (len - 1));
	}

	public static void main(String[] args) {
		int[] test_in = { 3, 2, 1, 0, 4 };
		Solution test = new Solution();
		System.out.println(test.canJump(test_in));

	}

}
