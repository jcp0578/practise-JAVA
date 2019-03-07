package SearchRotatedArray;
/*
 * AC but use too much Memory
 */
public class Solution {
	public static int search(int[] nums, int target) {
		int len = nums.length;
		if (len == 0)
			return -1;
		else if (len == 1) {
			if (nums[0] == target)
				return 0;
			else
				return -1;
		}
		int l = 0, r = len - 1;
		int mid;
		while (l < r) {
			mid = (l + r) / 2;
			int num_temp1 = nums[l];
			int num_temp2 = nums[mid];
			int num_temp3 = nums[r];

			if (num_temp2 == target)
				return mid;
			if (num_temp1 == target)
				return l;
			if (num_temp3 == target)
				return r;

			if (num_temp1 < target) {
				if (num_temp2 < target && num_temp2 > num_temp1) {
					l = mid + 1;

				} else {
					r = mid - 1;
				}
			} else {
				if (num_temp2 < num_temp1 && target < num_temp2) {
					r = mid - 1;
				} else {
					l = mid + 1;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] num_in = { 2, 3 };
		int target = 5;
		System.out.println(search(num_in, target));
	}
}
