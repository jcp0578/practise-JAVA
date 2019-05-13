package twoSum;

import java.util.Arrays;

/*
 * 两数之和 II - 输入有序数组
 * AC
 * 2ms - 60.62%
 * 
 */
public class Solution {
	public int[] twoSum(int[] numbers, int target) {
		if (numbers == null)
			return new int[2];
		int[] res = new int[0];
		int len = numbers.length;
		res[0] = 0;
		res[1] = len - 1;

		while (res[0] < res[1]) {
			int temp = numbers[res[0]] + numbers[res[1]];
			if (temp > target) {
				res[1]--;
			} else if (temp < target) {
				res[0]++;
			} else
				break;
		}
		if (res[0] >= res[1])
			return new int[0];
		else {
			res[0]++;
			res[1]++;
			return res;
		}

	}

	public static void main(String[] args) {
		int[] test_in = { 2, 7, 11, 15 };
		int t = 9;
		Solution test = new Solution();
		System.out.println(Arrays.toString(test.twoSum(test_in, t)));
	}

}
