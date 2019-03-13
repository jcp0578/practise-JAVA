package moveZeroes;

/*
 * 283. 移动零
 * https://leetcode-cn.com/problems/move-zeroes/
 * 
 * AC 3ms
 */
public class Solution {
	public void moveZeroes(int[] nums) {
		int move_index = 0;
		int i = 0;
		for (i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				if (move_index != i) {
					nums[move_index] = nums[i];
				}
				move_index++;
			}
		}
		for (i = move_index; i < nums.length; i++) {
			nums[i] = 0;
		}
	}

	public static void main(String[] args) {
		int[] num_in = {};
		Solution test = new Solution();
		test.moveZeroes(num_in);
		for (int t : num_in) {
			System.out.print(t);
			System.out.print(" ");
		}
		System.out.print('\n');
	}

}
