package minimizeError;

import java.util.ArrayList;
import java.util.Collections;

/*
 * 3. 最小化舍入误差以满足目标
 * 
 * error?
 */
public class Solution {
	public String minimizeError(String[] prices, int target) {
		int len = prices.length;
		ArrayList<Integer> prices_f = new ArrayList<Integer>();
		for (int i = 0; i < len; i++) {
			prices_f.add((int) (Double.parseDouble(prices[i])*1000));
		}
		int min_t = 0;
		int max_t = 0;
		for (int i = 0; i < len; i++) {
			min_t += prices_f.get(i)/1000;
			max_t += (prices_f.get(i)-1)/1000+1;
		}
		if (target < min_t || target > max_t) {
			return "-1";
		}
		Collections.sort(prices_f, (a,b)->(a%1000-b%1000));
		int change_num = max_t - target;
		int out = 0;
		for (int i = 0; i < len; i++) {
			if (i < change_num) {
				out+=prices_f.get(i)%1000;
			} else {
				if(prices_f.get(i)%1000==0)
					out+=0;
				else
					out+=1000-prices_f.get(i)%1000;
			}
		}
		return String.format("%.3f", ((double)out/1000));
	}

	public static void main(String[] args) {
		String[] test_in = { "176.482","198.901","36.649","484.363","39.106","706.278","237.805","606.143","909.029" };
		int test_target = 3400;
		Solution test = new Solution();
		System.out.println(test.minimizeError(test_in, test_target));

	}

}
