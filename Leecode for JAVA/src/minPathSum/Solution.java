package minPathSum;

import java.util.Arrays;

/*
 * tatil:64. 最小路径和
 * time:2ms - 99.81%
 * memory:39.2MB - 89.49%
 * https://leetcode-cn.com/submissions/detail/23848363/
 * AC
 * 
 */
public class Solution {
	public int minPathSum(int[][] grid) {
		if (grid == null)
			return 0;
		int len_y = grid.length;
		if (len_y == 0)
			return 0;
		int len_x = grid[0].length;
		int[] save = new int[len_x];
		Arrays.fill(save, 0);
		save[0] = grid[0][0];
		for (int i = 1; i < len_x; i++) {
			save[i] = save[i - 1] + grid[0][i];
		}

		for (int i = 1; i < len_y; i++) {
			save[0] += grid[i][0];
			for (int j = 1; j < len_x; j++) {
				save[j] = Math.min(save[j - 1], save[j]) + grid[i][j];
			}
		}
		return save[len_x - 1];
	}

	public static void main(String[] args) {
		int test_in[][] = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		for (int temp[] : test_in) {
			System.out.println(Arrays.toString(temp));
		}
		System.out.println();
		Solution test = new Solution();
		System.out.println(test.minPathSum(test_in));
	}

}
