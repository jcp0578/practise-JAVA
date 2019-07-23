package rotate;

import java.util.Arrays;

/*
 * title:旋转图像
 * tiem:1ms - 77.72%
 * AC
 * 
 */
public class Solution {

	public void diagonal(int[][] matrix) {
		int len = matrix.length;
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}

	public void horizontal(int[][] matrix) {
		int len = matrix.length;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len / 2; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][len - j - 1];
				matrix[i][len - j - 1] = temp;
			}
		}
	}

	public void rotate(int[][] matrix) {
		if (matrix == null)
			return;
		this.diagonal(matrix);
		this.horizontal(matrix);
	}

	public static void main(String[] args) {
		int test_in[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		for (int temp[] : test_in) {
			System.out.println(Arrays.toString(temp));
		}
		System.out.println();
		Solution test = new Solution();
		test.rotate(test_in);
		for (int temp[] : test_in) {
			System.out.println(Arrays.toString(temp));
		}

	}

}
