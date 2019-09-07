package checkRecord;

import java.util.Arrays;

/*
 *dp[i][j]  i:index j:state
 *A     0
 *L     1
 *LL    2
 *P     3
 *(A)L  4
 *(A)LL 5 
 *(A)P  6
 *
 */

/*
 *  titel :  学生出勤记录 II
 *  url : https://leetcode-cn.com/problems/student-attendance-record-ii/submissions/
 *  time: 136ms - 17.24%
 *  memory: 90.4MB - 14.29%
 *  AC but too slow
 * 
 */
public class Solution {
	final long mod = 1000000000 + 7;

	public int checkRecord(int n) {
		long[][] dp = new long[n][7];
		dp[0][0] = 1;
		dp[0][1] = 1;
		dp[0][2] = 0;
		dp[0][3] = 1;
		dp[0][4] = 0;
		dp[0][5] = 0;
		dp[0][6] = 0;

		for (int i = 1; i < n; i++) {
			dp[i][0] = dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3];
			dp[i][1] = dp[i - 1][3];
			dp[i][2] = dp[i - 1][1];
			dp[i][3] = dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3];
			dp[i][4] = dp[i - 1][0] + dp[i - 1][6];
			dp[i][5] = dp[i - 1][4];
			dp[i][6] = dp[i - 1][0] + dp[i - 1][4] + dp[i - 1][5] + dp[i - 1][6];
			
			checkMod(dp[i]);
		}

		/* out */
		int res = 0;
		for (int i = 0; i < 7; i++) {
			res += dp[n - 1][i];
			if (res >= mod) {
				res %= mod;
			}
		}
		return res;
	}

	private void checkMod(long[] data_temp) {
		int len = data_temp.length;
		for (int i = 0; i < len; i++) {
			if (data_temp[i] >= mod) {
				data_temp[i] %= mod;
			}
		}
	}

	public static void main(String[] args) {
		int test_in = 2;
		Solution test = new Solution();
		System.out.println(test.checkRecord(test_in));

	}

}
