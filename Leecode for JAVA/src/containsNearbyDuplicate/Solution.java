package containsNearbyDuplicate;

import java.util.HashMap;

/*
 * 存在重复元素 II
 * AC
 * 36ms - 34.95%
 * 
 */
public class Solution {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		if (nums == null)
			return false;
		HashMap<Integer, Integer> map = new HashMap<>();
		int len = nums.length;

		for (int i = 0; i < len && i <= k; i++) {
			if (map.containsKey(nums[i]) == true) {
				return true;
			} else {
				map.put(nums[i], 1);
			}
		}

		for (int i = k + 1; i < len; i++) {
			map.put(nums[i - k - 1], map.get(nums[i - k - 1]) - 1);

			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
			if (map.get(nums[i]) >= 2)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int[] test_in1 = { 1,0,1,1 };
		int test_in2 = 0;
		Solution test = new Solution();
		System.out.println(test.containsNearbyDuplicate(test_in1, test_in2));

	}

}
