package setZeroes;

import java.util.Arrays;

/*
 * 矩阵置零
 * 空间复杂度O(m + n) 
 * AC
 * 2ms - 96.92%
 */
public class Solution {
	public void setZeroes(int[][] matrix) {
		if (matrix == null)
			return;
		int len_r = matrix.length;
		if (len_r <= 0)
			return;
		int len_l = matrix[0].length;
		if (len_l <= 0)
			return;

		boolean[] flag = new boolean[len_r + len_l];

		for (int i = 0; i < len_r; i++) {
			for (int j = 0; j < len_l; j++) {
				if (matrix[i][j] == 0) {
					flag[i] = true;
					flag[len_r + j] = true;
				}
			}
		}

		for (int i = 0; i < len_r; i++) {
			if (flag[i]) {
				for (int j = 0; j < len_l; j++)
					matrix[i][j] = 0;
			}
		}

		for (int i = len_r; i < len_r + len_l; i++) {
			if (flag[i]) {
				for (int j = 0; j < len_r; j++)
					matrix[j][i - len_r] = 0;
			}
		}

		return;
	}

	public static void main(String[] args) {
		int[][] test_in = { { 1, 1, 2, 1 }, { 3, 0, 5, 2 }, { 1, 3, 1, 5 } };
		Solution test = new Solution();
		test.setZeroes(test_in);
		for (int[] t : test_in) {
			System.out.println(Arrays.toString(t));
		}

	}

}
