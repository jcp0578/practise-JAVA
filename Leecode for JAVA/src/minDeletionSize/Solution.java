package minDeletionSize;

/*
 * 删列造序 III
 * DP
 * dp[i] 表示每个字符串从索引0到i最长的字典序排列长度
 * 遍历每个字符串，判断索引i是否都是索引j的升序
 * AC
 * 21ms
 * 
 */
public class Solution {
	public int minDeletionSize(String[] A) {
		if (A == null)
			return 0;
		int len_A = A.length;
		int len_str = A[0].length();
		int[] dp = new int[len_str];
		for (int i = 0; i < len_str; i++) {
			for (int j = 0; j < i; j++) {
				int k = 0;
				for (; k < len_A; k++)// 搜索每个字符串
				{
					if (A[k].charAt(i) < A[k].charAt(j))
						break;
				}
				if (k == len_A) {
					if (dp[j] + 1 > dp[i])
						dp[i] = dp[j] + 1;
				}
			}
		}
		int max_len = 0;
		for (int i = 0; i < len_str; i++) {
			if (dp[i] > max_len)
				max_len = dp[i];
		}
		return len_str - max_len - 1;
	}

	public static void main(String[] args) {
		String[] test_in = { "babca", "bbazb" };
		Solution test = new Solution();
		System.out.println(test.minDeletionSize(test_in));

	}

}
