package longestIncreasingPath;

/*
 * 矩阵中的最长递增路径
 * https://leetcode-cn.com/explore/interview/card/top-interview-quesitons-in-2018/272/dynamic-programming/1181/
 * 
 * 回溯法，穷举，利用二维数据记录路径
 * out time
 * 134/137
 * 
 */
public class Solution {
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
		for (int i = 0; i < len_y; i++) {
			for (int j = 0; j < len_x; j++) {
				// 与上一行的对比
				if (i > 0) {
					if (matrix[i][j] > matrix[i - 1][j])
						continue;
				}
				// 与左一行的对比
				if (j > 0) {
					if (matrix[i][j] >matrix[i][j - 1])
						continue;
				}
				int[][] matrix_use = new int[len_y][len_x];
				int temp = find(matrix, matrix_use, i, j,Integer.MIN_VALUE);
				out_t = (out_t > temp) ? out_t : temp;
			}
		}
		return out_t;

	}

	private static int find(int[][] matrix, int[][] matrix_use, int i, int j,int last_val) {
		// 越界
		if (i < 0 || i >= len_y)
			return 0;
		if (j < 0 || j >= len_x)
			return 0;
		// 已使用
		if (matrix_use[i][j] == 1)
			return 0;
		
		if(matrix[i][j] <=last_val)
			return 0;
		
		int out_temp = 0;
		matrix_use[i][j] = 1;
		
		out_temp = Math.max(out_temp, 1 + find(matrix, matrix_use, i + 1, j,matrix[i][j]));

		out_temp = Math.max(out_temp, 1 + find(matrix, matrix_use, i - 1, j,matrix[i][j]));

		out_temp = Math.max(out_temp, 1 + find(matrix, matrix_use, i, j + 1,matrix[i][j]));

		out_temp = Math.max(out_temp, 1 + find(matrix, matrix_use, i, j - 1,matrix[i][j]));
		
		matrix_use[i][j] = 0;
		return out_temp;
	}

	public static void main(String[] args) {
		int[][] nums_in = { {7,8,9},{9,7,6},{7,2,3}};
		System.out.println(longestIncreasingPath(nums_in));

	}

}
