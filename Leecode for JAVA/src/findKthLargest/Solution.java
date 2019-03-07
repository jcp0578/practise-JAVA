package findKthLargest;
/*
 * 215. 数组中的第K个最大元素
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/submissions/
 * 8ms
 * AC but need sort by myself
 */
import java.util.Arrays;

public class Solution {
	public static int findKthLargest(int[] nums, int k) {
		Arrays.sort(nums);

		return nums[nums.length - k];

	}

	public static void main(String[] args) {
		int[] nums_in = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
		int k = 6;
		System.out.println(findKthLargest(nums_in, k));
	}
}
