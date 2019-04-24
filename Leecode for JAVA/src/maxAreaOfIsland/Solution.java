package maxAreaOfIsland;

/*
 * 岛屿的最大面积
 * DFS
 * AC
 * 9ms - 85.19%
 * 空间还可继续优化
 */
public class Solution {
	int len_r;
	int len_l;
	boolean[][] visit;
	int[][] _grid;

	public int maxAreaOfIsland(int[][] grid) {
		if (grid == null)
			return 0;
		this.len_r = grid.length;
		if (len_r == 0)
			return 0;
		this.len_l = grid[0].length;
		this.visit = new boolean[len_r][len_l];
		this._grid = grid;
		int res = 0;
		for (int i = 0; i < this.len_r; i++) {
			for (int j = 0; j < this.len_l; j++) {
				int temp = find(i, j);
				if (temp > res)
					res = temp;
			}
		}
		return res;
	}

	private int find(int i, int j) {
		if (i < 0 || j < 0 || i >= this.len_r || j >= this.len_l || this._grid[i][j] == 0)
			return 0;
		if (this.visit[i][j])
			return 0;
		this.visit[i][j] = true;
		return (1 + find(i - 1, j) + find(i + 1, j) + find(i, j - 1) + find(i, j + 1));
	}

	public static void main(String[] args) {
		int[][] test_in = { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
				{ 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
				{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };
		Solution test = new Solution();
		System.out.println(test.maxAreaOfIsland(test_in));

	}

}
