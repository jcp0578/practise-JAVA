package setZeroes;

import java.util.Arrays;

/*
 * 矩阵置零
 * 空间复杂度O(1) 
 * AC
 * 3ms - 75.90%
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

		boolean flag_row = false;
		boolean flag_col  = false;

		for (int i = 0; i < len_r; i++) {
			for (int j = 0; j < len_l; j++) {
				if (matrix[i][j] == 0) {
					if (i == 0)
						flag_row = true;
					else if (j == 0)
						flag_col = true;
					else {
						matrix[0][j] = 0;
						matrix[i][0] = 0;
					}
				}
			}
		}

		for (int i = len_r - 1; i >= 0; i--) {
			for (int j = len_l - 1; j >= 0; j--) {
				if ((i == 0 && flag_row) || (j == 0 && flag_col) || matrix[0][j] == 0 || matrix[i][0] == 0) {
					matrix[i][j] = 0;
				}
			}
		}

		return;
	}

	public static void main(String[] args) {
		int[][] test_in = { { 1, 1, 2, 1 }, { 0, 1, 5, 2 }, { 1, 3, 1, 5 } };
		Solution test = new Solution();
		test.setZeroes(test_in);
		for (int[] t : test_in) {
			System.out.println(Arrays.toString(t));
		}

	}

}
