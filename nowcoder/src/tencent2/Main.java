package tencent2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[] money = new int[n];
		for (int i = 0; i < n; i++) {
			money[i] = sc.nextInt();
		}
		boolean flag = false;
		for (int i = 0; i < n; i++) {
			if (money[i] == 1) {
				flag = true;
			}
		}
		if (flag) {
			int[] dp = new int[m + 1];
			int[][] dp_temp = new int[m + 1][n];
			int sum_dp_temp=0;
			int use=0;
			Arrays.fill(dp, m + 1);
			dp[0] = 0;
			for (int i = 1; i <= m; i++) {
				if(i<=sum_dp_temp)
				{
					dp[i]=use;
					continue;
				}
				for (int j = 0; j < n; j++) {
					if (i >= money[j]) {
						if (dp[i] > (dp[i - money[j]] + 1)) {
							dp[i] = dp[i - money[j]] + 1;
							for (int ii = 0; ii < n; ii++) {
								dp_temp[i][ii] = dp_temp[i - money[j]][ii];
							}
							dp_temp[i][j]++;
							sum_dp_temp+=money[j];
							use++;
						}
					}
				}
			}
			int max_t = 0;
			int sum = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (dp_temp[j][i] > max_t) {
						max_t = dp_temp[j][i];
					}
				}
				sum += max_t;
			}
			System.out.println(sum);
		} else {
			System.out.println("-1");
		}
	}
}

/*
 * import java.util.Arrays; import java.util.Scanner;
 * 
 * public class Main {
 * 
 * public static void main(String[] args) { Scanner sc = new Scanner(System.in);
 * int m = sc.nextInt(); int n = sc.nextInt(); int[] money = new int[n]; for
 * (int i = 0; i < n; i++) { money[i] = sc.nextInt(); } boolean flag = false;
 * for (int i = 0; i < n; i++) { if (money[i] == 1) { flag = true; } } if (flag)
 * { int[] dp = new int[m + 1]; Arrays.fill(dp, m + 1); dp[0] = 0; for (int i =
 * 1; i <= m; i++) { for (int j = 0; j < n; j++) { if (i >= money[j]) { dp[i] =
 * Math.min(dp[i - money[j]] + 1, dp[i]); } } } int max_t=dp[1]; for (int i = 2;
 * i <= m; i++) { if(dp[i]>max_t) { max_t=dp[i]; } } System.out.println(max_t);
 * } else { System.out.println("-1"); }
 * 
 * }
 * 
 * }
 */
