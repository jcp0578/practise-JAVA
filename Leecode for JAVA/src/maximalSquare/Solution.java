package maximalSquare;

/*
 * 最大正方形
 * 利用row_ones与line_ones记录每点的行列方向上的连续1的个数
 * min_t=min(row_ones[i]line_ones[i]), 取(i-min_t)~i范围上line_ones的最小值，以判断是否构成正方形
 * AC
 * 10ms - 89.56%
 * 
 */
public class Solution {
	public int maximalSquare(char[][] matrix) {
		if (matrix == null)
			return 0;
		int len_r = matrix.length;
		if (len_r == 0)
			return 0;
		int len_l = matrix[0].length;
		if (len_l == 0)
			return 0;

		int res = 0;
		int[] row_ones = new int[len_l];
		int[] line_ones = new int[len_l];
		for (int j = 0; j < len_r; j++) {
			for (int i = 0; i < len_l; i++) {
				// 记录每点的行列方向上的连续1的个数

				if (matrix[j][i] == '1')
					line_ones[i] = line_ones[i] + 1;
				else
					line_ones[i] = 0;

				if (matrix[j][i] == '1')
					row_ones[i] = (i == 0) ? 1 : (row_ones[i - 1] + 1);
				else
					row_ones[i] = 0;

				int min_t = Math.min(line_ones[i], row_ones[i]);
				if (min_t > res) {
					// 判断可以构成正方形的边长
					int temp = min_t;
					for (int k = i; k > (i - temp); k--) {
						if (line_ones[k] < temp)
							temp = line_ones[k];
					}
					if (temp > res)
						res = temp;
				}
			}
		}
		return res * res;
	}

	public static void main(String[] args) {
		char[][] test_in = { { '0', '1', '1', '0', '1' }, { '1', '1', '0', '1', '0' }, { '0', '1', '1', '1', '0' },
				{ '1', '1', '1', '1', '0' }, { '1', '1', '1', '1', '1' }, { '0', '0', '0', '0', '0' } };
		Solution test = new Solution();
		System.out.println(test.maximalSquare(test_in));

	}

}
