package SearchRotatedArray;

public class Solution_fast {
	public int search(int[] nums, int target) {
		if (nums.length == 0)
			return -1;
		if (nums[0] == target)
			return 0;
		else if (nums[0] < target) {
			int low = 1, high = nums.length - 1;
			while (low <= high) {
				int mid = (low + high) / 2;
				if (nums[mid] == target)
					return mid;
				else if (nums[mid] >= nums[low]) {
					if (nums[mid] > target)
						high = mid - 1;
					else
						low = mid + 1;
				} else
					high = mid - 1;
			}
			return -1;
		} else {
			int low = 1, high = nums.length - 1;
			while (low <= high) {
				int mid = (low + high) / 2;
				if (nums[mid] == target)
					return mid;
				else if (nums[mid] <= nums[high]) {
					if (nums[mid] > target)
						high = mid - 1;
					else
						low = mid + 1;
				} else
					low = mid + 1;
			}
			return -1;
		}
	}
}
