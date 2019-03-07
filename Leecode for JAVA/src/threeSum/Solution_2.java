package threeSum;

import java.util.*;

public class Solution_2 {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		int r = nums.length - 1;
		for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			int j = i + 1;
			while (r > j && nums[i] + nums[j] + nums[r] > 0) {
				// 最小值加上右边界仍大于0，则右边界过大，缩小右边界
				r--;
			}
			if (r < j) {
				break;
			}
			int k = r;
			while (j < k) {
				if (nums[i] + nums[j] + nums[k] < 0) {
					j++;
				} else if (nums[i] + nums[j] + nums[k] > 0) {
					k--;
				} else {
					List<Integer> item = Arrays.asList(nums[i], nums[k], nums[j]);
					result.add(item);
					while (j < k && nums[j] == nums[j + 1])
						j++;
					while (j < k && nums[k] == nums[k - 1])
						k--;
					j++;
					k--;
				}
			}
		}
		return result;
	}
}
