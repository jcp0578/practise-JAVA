package removeBoxes;

/*
 * 移除盒子
 * DP
 * dp[i][j][k]表示从索引i到j且i的左边有k个与boxes[i]相同的数 时的最大值
 * dp[i][j][k]= max( (1+k)*(1+k)+dp[i+1][j][0] ,  dp[i+1][m-1][0]+dp[m][j][k+1]{boxes[m]==boxes[i]})
 * 
 * 参考：https://www.cnblogs.com/grandyang/p/6850657.html
 * 
 * AC
 * 33ms - 88.46%
 */
public class Solution {
	public int removeBoxes(int[] boxes) {
		if (boxes == null)
			return 0;
		int len = boxes.length;
		int dp[][][] = new int[len][len][len];
		return Deal(0, len - 1, 0, boxes, dp);
	}

	private int Deal(int i, int j, int k, int[] boxes, int[][][] dp) {
		if (i > j)
			return 0;

		while (i < j) {
			if (boxes[i + 1] == boxes[i]) {
				i++;
				k++;
			} else
				break;
		}

		if (dp[i][j][k] != 0)
			return dp[i][j][k];
		int res = (1 + k) * (1 + k) + Deal(i + 1, j, 0, boxes, dp);
		for (int m = i + 1; m <= j; m++) {
			if (boxes[m] == boxes[i]) {
				res = Math.max(res, Deal(i + 1, m - 1, 0, boxes, dp) + Deal(m, j, k + 1, boxes, dp));
			}
		}
		dp[i][j][k] = res;
		return res;
	}

	public static void main(String[] args) {
		int[] test_in = { 1, 1, 2, 2, 2, 3, 1, 1, 1 };
		Solution test = new Solution();
		System.out.println(test.removeBoxes(test_in));

	}

}
