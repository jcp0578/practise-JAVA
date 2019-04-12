package findRotateSteps;

import java.util.ArrayList;

/*
 * 自由之路
 * 
 * DP
 * dp[i][j] 表示从ring[i]出发，输出字符串key[j:]时的最小操作数
 * dp[i,j] = min(len(ring[i], ring[k]) + dp[k,j+1]), 满足ring[k] == key[j]
 * 
 * 112ms - 
 * AC but slow
 */
public class Solution {
	public int findRotateSteps(String ring, String key) {
		if (ring == null || key == null)
			return 0;
		int key_len = key.length();
		if (key_len == 0)
			return 0;
		int ring_len = ring.length();
		int[][] dp = new int[ring_len][key_len + 1];

		ArrayList<ArrayList<Integer>> index = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < 26; i++)
			index.add(new ArrayList<Integer>());

		for (int i = 0; i < ring_len; i++)
			index.get(ring.charAt(i) - 'a').add(i);

		for (int j = key_len - 1; j >= 0; j--) {
			for (int i = 0; i < ring_len; i++) {
				dp[i][j] = Integer.MAX_VALUE;
				char ch = key.charAt(j);
				for (int k = 0; k < index.get(ch - 'a').size(); k++) {
					int pos = index.get(ch - 'a').get(k);
					int step = (i > pos ? Math.min(i - pos, pos - i + ring_len)
							: Math.min(pos - i, i - pos + ring_len));
					dp[i][j] = Math.min(dp[i][j], step + dp[pos][j + 1]);
				}
			}
		}
		return dp[0][0] + key_len;
	}

	public static void main(String[] args) {
		String test_ring = "bicligfijg";
		String test_key = "cgijcjlgiggigigijiiciicjilicjflccgilcflijgigbiifiggigiggibbjbijlbcifjlblfggiibjgblgfiiifgbiiciffgbfl";
		Solution test = new Solution();
		System.out.println(test.findRotateSteps(test_ring, test_key));

	}

}
