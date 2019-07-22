package containsNearbyAlmostDuplicate;

import java.util.ArrayList;

/*
 * 存在重复元素 III
 * AC but too slow
 * 237ms - 21.54%
 * 
 */
public class Solution {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums == null)
			return false;
		int len = nums.length;
		ArrayList<Integer> save = new ArrayList<>();
		for (int i = 0; i < len; i++) {
			if (i > k) {
				save.remove(Integer.valueOf(nums[i - k - 1]));
			}
			int j = 0;
			for (; j < save.size(); j++) {
				if (save.get(j) < nums[i])
					continue;
				else
					break;
			}
			save.add(j, new Integer(nums[i]));
			if (j != 0) {
				if (((long)nums[i] - (long)save.get(j - 1)) <= t)
					return true;
			}
			if (j != save.size() - 1) {
				if (((long)save.get(j + 1) - (long)nums[i]) <= t)
					return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] test_in = { -1,2147483647};
		int k = 1;
		int t = 2147483647;
		Solution test = new Solution();
		System.out.println(test.containsNearbyAlmostDuplicate(test_in, k, t));

	}

}
