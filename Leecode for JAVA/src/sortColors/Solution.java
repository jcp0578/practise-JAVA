package sortColors;

import java.util.Arrays;

/*
 * titel:颜色分类
 * time:1ms - 98.43%
 * memory:36.1 MB - 35.88%
 * AC
 * 
 */
public class Solution {

	public void sortColors(int[] nums) {
		if (nums == null)
			return;
		int len = nums.length;
		int left = 0;
		int right = len - 1;
		while ((left < len) && nums[left] == 0)
			left++;
		while ((right >= 0) && nums[right] == 2)
			right--;
		int i = left;
		while (i <= right) {
			if (nums[i] == 0) {
				swap(nums, i, left);
				left++;
			} else if (nums[i] == 2) {
				swap(nums, i, right);
				right--;
				i--;
			} else {

			}
			i++;
		}
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;

	}

	public static void main(String[] args) {
		int[] test_in = { 1, 2, 0 };
		Solution test = new Solution();
		test.sortColors(test_in);
		System.out.println(Arrays.toString(test_in));

	}

}
