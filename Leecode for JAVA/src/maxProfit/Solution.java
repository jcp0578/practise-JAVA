package maxProfit;

/*
 * 买卖股票的最佳时机 II
 * 存在差值即累加
 * AC
 * 
 */
public class Solution {
	public int maxProfit(int[] prices) {
		if (prices == null)
			return 0;
		int len = prices.length;
		if (len <= 1)
			return 0;
		int out = 0;
		for (int i = 1; i < len; i++) {
			if (prices[i] > prices[i - 1])
				out += (prices[i] - prices[i - 1]);
		}
		return out;
	}

	public static void main(String[] args) {
		int[] test_in = { 7, 6, 6, 7, 1 };
		Solution test = new Solution();
		System.out.println(test.maxProfit(test_in));

	}

}
