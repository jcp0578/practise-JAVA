package canJump;

/*
 * 跳跃游戏
 * AC
 * 2ms - 98.93%
 * DP
 * 
 */
public class Solution {
	public boolean canJump(int[] nums) {
		if (nums == null)
			return false;
		int len = nums.length;
		int max_len = 0;
		for (int i = 0; i < len; i++) {
			if (max_len >= i) {
				max_len = Math.max(max_len, i + nums[i]);
				if (max_len >= (len - 1))
					break;
			} else
				break;
		}
		return (max_len >= (len - 1));
	}

	public static void main(String[] args) {
		int[] test_in = { 2, 3, 1, 1, 4 };
		Solution test = new Solution();
		System.out.println(test.canJump(test_in));

	}

}
