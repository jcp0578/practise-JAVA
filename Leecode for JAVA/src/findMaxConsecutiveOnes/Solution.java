package findMaxConsecutiveOnes;

/*
 * 最大连续1的个数
 * 
 * AC but slow
 * 10ms - 26.08%
 */
public class Solution {
	public int findMaxConsecutiveOnes(int[] nums) {
		if (nums == null)
			return 0;
		int len = nums.length;
		if (len == 0)
			return 0;
		int max_len = nums[0];
		for (int i = 1; i < len; i++) {
			if (nums[i] == 1) {
				nums[i] = nums[i - 1] + 1;
				if (nums[i] > max_len)
					max_len = nums[i];
			}
		}
		return max_len;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		int[] test_in = { 1, 1, 0, 1, 1, 1 };
		System.out.println(test.findMaxConsecutiveOnes(test_in));

	}

}
