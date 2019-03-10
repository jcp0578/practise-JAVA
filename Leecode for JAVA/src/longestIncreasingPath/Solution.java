package longestIncreasingPath;

import java.util.Arrays;

/*
 * 矩阵中的最长递增路径
 * https://leetcode-cn.com/explore/interview/card/top-interview-quesitons-in-2018/272/dynamic-programming/1181/
 * 
 * 动态规划,从单节点考虑，
 * AC but too slow
 * 93ms 5.71%
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

		long need_nums = len_x * len_y;
		int out_t = 1;
		int[][] matrix_out = new int[len_y][len_x];

		for (int[] temp : matrix_out) {
			Arrays.fill(temp, 1);
		}
		int[][] matrix_flag = new int[len_y][len_x];// 标识数据是否更新
		while (need_nums != 0) {
			for (int i = 0; i < len_y; i++) {
				for (int j = 0; j < len_x; j++) {
					if (matrix_flag[i][j] == 1)// 不需要更新
						continue;

					int flag = 0;
					if (i > 0) {
						if (matrix[i][j] > matrix[i - 1][j]) {
							matrix_out[i][j] = Math.max(matrix_out[i][j], matrix_out[i - 1][j] + 1);
							if (matrix_flag[i - 1][j] == 0)
								flag = 1;
						}
					}
					if (i < len_y - 1) {
						if (matrix[i][j] > matrix[i + 1][j]) {
							matrix_out[i][j] = Math.max(matrix_out[i][j], matrix_out[i + 1][j] + 1);
							if (matrix_flag[i + 1][j] == 0)
								flag = 1;
						}
					}
					if (j > 0) {
						if (matrix[i][j] > matrix[i][j - 1]) {
							matrix_out[i][j] = Math.max(matrix_out[i][j], matrix_out[i][j - 1] + 1);
							if (matrix_flag[i][j - 1] == 0)
								flag = 1;
						}
					}
					if (j < len_x - 1) {
						if (matrix[i][j] > matrix[i][j + 1]) {
							matrix_out[i][j] = Math.max(matrix_out[i][j], matrix_out[i][j + 1] + 1);
							if (matrix_flag[i][j + 1] == 0)
								flag = 1;
						}
					}
					if (matrix_out[i][j] > out_t)
						out_t = matrix_out[i][j];
					if (flag == 0) {
						need_nums--;
						matrix_flag[i][j] = 1;
					}
				}
			}
		}
		return out_t;
	}

	public static void main(String[] args) {
		int[][] nums_in = { { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 19, 18, 17, 16, 15, 14, 13, 12, 11, 10 },
				{ 20, 21, 22, 23, 24, 25, 26, 27, 28, 29 }, { 39, 38, 37, 36, 35, 34, 33, 32, 31, 30 },
				{ 40, 41, 42, 43, 44, 45, 46, 47, 48, 49 }, { 59, 58, 57, 56, 55, 54, 53, 52, 51, 50 },
				{ 60, 61, 62, 63, 64, 65, 66, 67, 68, 69 }, { 79, 78, 77, 76, 75, 74, 73, 72, 71, 70 },
				{ 80, 81, 82, 83, 84, 85, 86, 87, 88, 89 }, { 99, 98, 97, 96, 95, 94, 93, 92, 91, 90 },
				{ 100, 101, 102, 103, 104, 105, 106, 107, 108, 109 },
				{ 119, 118, 117, 116, 115, 114, 113, 112, 111, 110 },
				{ 120, 121, 122, 123, 124, 125, 126, 127, 128, 129 },
				{ 139, 138, 137, 136, 135, 134, 133, 132, 131, 130 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

//		int[][] nums_in= {{7,8,9},{9,7,6},{7,2,3}};
		long startTime = System.currentTimeMillis();
		System.out.println(longestIncreasingPath(nums_in));
		long endTime = System.currentTimeMillis(); // 获取结束时间

		System.out.println("程序运行时间：" + (endTime - startTime) + "ms"); // 输出程序运行时间
	}

}
