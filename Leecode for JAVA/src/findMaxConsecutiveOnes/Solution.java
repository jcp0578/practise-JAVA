package findMaxConsecutiveOnes;

/*
 * 最大连续1的个数
 * 
 * AC
 * 8ms - 68.65%
 */
public class Solution {
	public int findMaxConsecutiveOnes(int[] nums) {
		if (nums == null)
			return 0;
		int len = nums.length;
		if (len == 0)
			return 0;
		int max_len = 0;
		int count = 0;
		for (int i = 0; i < len; i++) {
			if (nums[i] == 1)
				count++;
			else {
				if (count > max_len)
					max_len = count;
				count = 0;
			}
		}
		if (count > max_len)
			max_len = count;
		return max_len;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		int[] test_in = { 1 };
		System.out.println(test.findMaxConsecutiveOnes(test_in));

	}

}
