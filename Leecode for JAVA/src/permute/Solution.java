package permute;
/*
 * AC but use too much Memory
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public static List<List<Integer>> permute(int[] nums) {
		int nums_len = nums.length;
		List<List<Integer>> out_t = new ArrayList<List<Integer>>();
		if (nums_len == 0)
		{
			out_t.add(new ArrayList<Integer>());
			return out_t;
		}
			
		Arrays.sort(nums);
		out_t.add(ArraysAddtoList(nums));
		for (;;) {
			int swap_index = 0;
			int i;
			for (i = nums_len - 1; i > 0; i--) {
				if (nums[i] > nums[i - 1]) {
					swap_index = i - 1;
					break;
				}
			}
			if (i == 0)
				break;
			for (i = nums_len - 1; i > 0; i--) {
				if (nums[i] > nums[swap_index]) {
					int tmp = nums[i];
					nums[i] = nums[swap_index];
					nums[swap_index] = tmp;
					Arrays.sort(nums,swap_index+1,nums_len);
					out_t.add(ArraysAddtoList(nums));
					break;
				}
			}
		}

		return out_t;

	}

	private static List<Integer> ArraysAddtoList(int[] nums) {
		List<Integer> out_t = new ArrayList<Integer>();
		for (int num : nums) {
			out_t.add(num);
		}
		return out_t;
	}

	public static void main(String[] args) {
		int[] num_in = {};
		System.out.println(permute(num_in));
	}
}
