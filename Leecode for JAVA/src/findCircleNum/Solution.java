package findCircleNum;

/*
 * 朋友圈
 * DFS
 * AC
 * 3ms - 97.47%
 * 
 */
public class Solution {
	int len;

	public int findCircleNum(int[][] M) {
		if (M == null)
			return 0;
		this.len = M.length;
		if (this.len == 0)
			return 0;
		boolean[] visit = new boolean[this.len];
		int res = 0;
		for (int i = 0; i < this.len; i++) {
			if (visit[i])
				continue;
			else {
				res++;
				DFS(i, M, visit);
			}

		}
		return res;
	}

	private void DFS(int i, int[][] M, boolean[] visit) {
		if (visit[i])
			return;

		visit[i] = true;
		for (int j = 0; j < this.len; j++) {
			if (M[i][j] == 1)
				DFS(j, M, visit);
		}
	}

	public static void main(String[] args) {
		int[][] test_in = { { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 } };
		Solution test = new Solution();
		System.out.println(test.findCircleNum(test_in));

	}

}
