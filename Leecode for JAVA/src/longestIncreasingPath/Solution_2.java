package longestIncreasingPath;

public class Solution_2 {
	static int len_x;
	static int len_y;

	public static int longestIncreasingPath(int[][] matrix) {
		len_y = matrix.length;
		if (len_y == 0)
			return 0;
		len_x = matrix[0].length;
		if (len_x == 0)
			return 0;

		int out_t = 0;
		int[][] matrix_use = new int[len_y][len_x];
		for (int i = 0; i < len_y; i++) {
			for (int j = 0; j < len_x; j++) {
				int temp = find(matrix, matrix_use, i, j, Integer.MIN_VALUE);
				out_t = (out_t > temp) ? out_t : temp;
			}
		}
		return out_t;

	}

	private static int find(int[][] matrix, int[][] matrix_use, int i, int j, int last_val) {
		// 越界
		if (i < 0 || i >= len_y)
			return 0;
		if (j < 0 || j >= len_x)
			return 0;
		// 已使用
		if (matrix[i][j] <= last_val)
			return 0;
		if (matrix_use[i][j] == 0) {
			int out_temp = 0;

			out_temp = Math.max(out_temp, find(matrix, matrix_use, i + 1, j, matrix[i][j]));

			out_temp = Math.max(out_temp, find(matrix, matrix_use, i - 1, j, matrix[i][j]));

			out_temp = Math.max(out_temp, find(matrix, matrix_use, i, j + 1, matrix[i][j]));

			out_temp = Math.max(out_temp, find(matrix, matrix_use, i, j - 1, matrix[i][j]));

			matrix_use[i][j] = out_temp + 1;
		}

		return matrix_use[i][j];
	}
}
