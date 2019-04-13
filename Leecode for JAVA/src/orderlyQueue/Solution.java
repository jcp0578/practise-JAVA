package orderlyQueue;

/*
 * 有序队列
 * https://leetcode-cn.com/explore/interview/card/teambition/250/data-structure/1081/
 * 当K>=2,可以实现任意调整
 * 
 * AC
 * 5ms - 100%
 * 
 */

public class Solution {
	public String orderlyQueue(String S, int K) {
		if (S == null || k <= 0)
			return S;
		int len = S.length();
		if (len <= 1)
			return S;
		if (K >= 2) {
			int[] count = new int[26];
			for (int i = 0; i < len; i++) {
				count[S.charAt(i) - 'a']++;
			}
			StringBuffer out_t = new StringBuffer();
			for (int i = 0; i < 26; i++) {
				for (int j = 0; j < count[i]; j++)
					out_t.append((char) (i + 'a'));
			}
			return out_t.toString();
		} else {
			String out_t = S;
			S = S + S;
			for (int i = 0; i < len; i++) {
				String temp = S.substring(i, i + len);
				if (out_t.compareTo(temp) > 0)
					out_t = temp;
			}
			return out_t;
		}
	}

	public static void main(String[] args) {
		String test_set = "nhtp";
		int K = 1;
		Solution test = new Solution();
		System.out.println(test.orderlyQueue(test_set, K));

	}

}
