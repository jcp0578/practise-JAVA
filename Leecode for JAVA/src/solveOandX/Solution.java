package solveOandX;

/*
 * 被围绕的区域
 * 从边界遍历‘O’元素
 * 用visit表示能否被访问
 * 不能被访问则改为‘X’
 * 
 * AC
 * 3ms - 97.30%
 * 
 */
public class Solution {
	public void solve(char[][] board) {
		if (board == null)
			return;
		int len_r = board.length;
		if (len_r == 0)
			return;
		int len_l = board[0].length;
		if (len_l == 0)
			return;
		boolean[][] visit = new boolean[len_r][len_l];
		for (int j = 0; j < len_l; j++)
			DFS(0, j, board, visit);
		for (int j = 0; j < len_l; j++)
			DFS(len_r - 1, j, board, visit);
		for (int i = 0; i < len_r; i++)
			DFS(i, 0, board, visit);
		for (int i = 0; i < len_r; i++)
			DFS(i, len_l - 1, board, visit);

		for (int i = 0; i < len_r; i++) {
			for (int j = 0; j < len_l; j++) {
				if (visit[i][j] == false)
					board[i][j] = 'X';
			}
		}

	}

	private void DFS(int i, int j, char[][] board, boolean[][] visit) {
		if (i < 0 || i >= board.length)
			return;
		if (j < 0 || j >= board[0].length)
			return;
		if (board[i][j] == 'X' || visit[i][j] == true)
			return;

		visit[i][j] = true;
		DFS(i, j - 1, board, visit);
		DFS(i, j + 1, board, visit);
		DFS(i - 1, j, board, visit);
		DFS(i + 1, j, board, visit);
	}

	public static void main(String[] args) {
		char[][] test_in = { { 'X', 'X', 'X' }, { 'X', 'O', 'X' }, { 'X', 'X', 'X' }, { 'X', 'X', 'X' } };
		Solution test = new Solution();
		test.solve(test_in);
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
