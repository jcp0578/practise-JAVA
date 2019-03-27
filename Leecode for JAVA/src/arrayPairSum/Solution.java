package arrayPairSum;

import java.util.Arrays;

/*
 * 数组拆分 I
 * 排序后隔一位相加后输出
 * AC
 */
public class Solution {
	public int arrayPairSum(int[] nums) {
		Arrays.sort(nums);
		int ret = 0;
		for (int i = 0; i < nums.length; i += 2) {
			ret += nums[i];
		}
		return ret;
	}

	public static void main(String[] args) {
		int[] test1 = { 1, 4, 3, 2 };
		Solution test = new Solution();
		System.out.println(test.arrayPairSum(test1));

	}

}
