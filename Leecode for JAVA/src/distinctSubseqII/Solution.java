package distinctSubseqII;

/*
 * 不同的子序列 II
 * DP
 * 以字符ch结束的子串为sum(count)+1
 * AC 
 * 5ms - 100%
 * 
 */
public class Solution {
	public int distinctSubseqII(String S) {
		if (S == null)
			return 0;
		int[] count = new int[26];
		int sum = 0;
		for (int i = 0; i < S.length(); i++) {
			char ch = S.charAt(i);
			int temp = count[ch - 'a'];
			count[ch - 'a'] = sum + 1;
			if (count[ch - 'a'] > temp)
				sum += count[ch - 'a'] - temp;
			else
				sum += count[ch - 'a'] + 1000000007 - temp;
			if (sum >= 1000000007)
				sum %= 1000000007;
		}
		return sum;
	}

	public static void main(String[] args) {
		String test_in = "aba";
		Solution test = new Solution();
		System.out.println(test.distinctSubseqII(test_in));

	}

}
