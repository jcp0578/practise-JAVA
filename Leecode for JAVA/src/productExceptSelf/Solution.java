package productExceptSelf;

import java.util.Arrays;

/*
 * 238. 除自身以外数组的乘积
 * https://leetcode-cn.com/problems/product-of-array-except-self/
 * AC 1ms
 * https://leetcode-cn.com/submissions/detail/13797377/
 */
public class Solution {
	public static int[] productExceptSelf(int[] nums) {
		int len = nums.length;
		if (len < 2)
			return nums;
		int[] out_t = new int[len];

		out_t[0] = 1;
		for (int i = 1; i < len; i++)
			out_t[i] = out_t[i - 1] * nums[i - 1];

		int temp = nums[len - 1];
		for (int i = len - 2; i >= 0; i--) {
			out_t[i] *= temp;
			temp *= nums[i];
		}
		return out_t;

	}

	public static void main(String[] args) {
		int[] nums_in = { 2 };
		System.out.println(Arrays.toString(productExceptSelf(nums_in)));
	}
}
