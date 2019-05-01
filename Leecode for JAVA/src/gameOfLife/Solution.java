package gameOfLife;

/*
 * 生命游戏
 * AC 
 * 2ms - 74.37%
 * 利用高位保存下一个状态的值
 * 
 */

public class Solution {
	public void gameOfLife(int[][] board) {
		if (board == null)
			return;
		int len_r = board.length;
		if (len_r == 0)
			return;
		int len_l = board[0].length;
		if (len_l == 0)
			return;

		for (int i = 0; i < len_r; i++) {
			for (int j = 0; j < len_l; j++) {
				int temp = deal(i, j, board);
				if (board[i][j] == 0) {
					if (temp == 3)
						board[i][j] += 0x02;
					else
						board[i][j] += 0x00;
				} else {
					if (temp < 2 || temp > 3)
						board[i][j] += 0x00;
					else
						board[i][j] += 0x02;
				}
			}
		}
		for (int i = 0; i < len_r; i++) {
			for (int j = 0; j < len_l; j++) {
				board[i][j] = (board[i][j] >> 1);
			}
		}
	}

	private int deal(int i, int j, int[][] board) {
		int out = 0;
		int[] i_do = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] j_do = { -1, 0, 1, -1, 1, -1, 0, 1 };
		
		for (int k = 0; k < 8; k++) {
			int temp_i = i + i_do[k];
			if (temp_i < 0 || temp_i >= board.length)
				continue;
			int temp_j = j + j_do[k];
			if (temp_j < 0 || temp_j >= board[0].length)
				continue;
			if ((board[temp_i][temp_j] & 0x01) == 1)
				out++;
		}
		return out;
	}

	public static void main(String[] args) {
		int[][] test_in = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
		Solution test = new Solution();
		test.gameOfLife(test_in);
		for (int i = 0; i < test_in.length; i++) {
			for (int j = 0; j < test_in[0].length - 1; j++) {
				System.out.print(test_in[i][j]);
				System.out.print(", ");
			}
			System.out.print(test_in[i][test_in[0].length - 1]);
			System.out.println();
		}
	}

}
