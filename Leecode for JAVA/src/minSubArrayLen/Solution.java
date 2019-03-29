package minSubArrayLen;

/*
 * 长度最小的子数组
 * 
 * AC 
 * 3ms - 98.07%
 */
public class Solution {
	public int minSubArrayLen(int s, int[] nums) {
		int i = 0, j = 0;
		int len = nums.length;
		int ret = len + 1;
		int sum_t = 0;
		while (i < len) {
			sum_t += nums[i++];
			if (sum_t >= s) {
				while (sum_t >= s && j <= i && j < len) {
					sum_t -= nums[j++];
				}
				ret = Math.min(ret, i - j + 1);
			}
		}
		return (ret == len + 1) ? 0 : ret;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		int[] test_in = { 2, 3, 1, 2, 4, 1 };
		int test_in2 = 1;
		System.out.println(test.minSubArrayLen(test_in2, test_in));

	}
}
