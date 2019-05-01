package missingElement;

/*
 * 1. 有序数组中的缺失元素
 * AC
 */
public class Solution {
	public int missingElement(int[] nums, int k) {
		int len = nums.length;
		int start = nums[0];
		int i = 0;
		while (k > 0) {
			if (i < len) {
				if (nums[i] == start) {
					i++;
				} else {
					k--;
				}
				start++;
			} else {
				start += k;
				break;
			}
		}
		return start - 1;
	}

	public static void main(String[] args) {
		int[] test_in = { 1, 2, 4 };
		int test_k = 3;
		Solution test = new Solution();
		System.out.println(test.missingElement(test_in, test_k));

	}

}
