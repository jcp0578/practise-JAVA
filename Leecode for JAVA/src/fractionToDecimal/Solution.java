package fractionToDecimal;

import java.util.ArrayList;

/*
 *  分数到小数
 * 
 * AC but too slow
 */
public class Solution {
	public String fractionToDecimal(int numerator, int denominator) {
		if (denominator == 0)
			return "NaN";
		if (numerator == 0)
			return "0";
		long numerator_t=numerator;
		long denominator_t=denominator;
		StringBuilder out_t = new StringBuilder();
		if ((numerator_t > 0 && denominator_t < 0) || (numerator_t < 0 && denominator_t > 0))
			out_t.append('-');
		numerator_t = Math.abs(numerator_t);
		denominator_t = Math.abs(denominator_t);
		if (numerator_t >= denominator_t) {
			while (numerator_t >= denominator_t) {
				long temp = (numerator_t / denominator_t);
				numerator_t -= denominator_t * temp;
				out_t.append(temp);
			}
		} else {
			out_t.append('0');
		}
		if (numerator_t != 0) {
			out_t.append('.');
			ArrayList<Long> dividend = new ArrayList<Long>();
			ArrayList<Long> res = new ArrayList<Long>();
			while (numerator_t != 0) {
				dividend.add(numerator_t);
				long temp =  (numerator_t * 10 / denominator_t);
				numerator_t = numerator_t * 10 - denominator_t * temp;
				res.add(temp);
				if (dividend.indexOf(numerator_t) != -1) {
					break;
				}
			}
			if (numerator_t == 0) {
				for (Long t : res) {
					out_t.append(t);
				}
			} else {
				int back_index = dividend.indexOf(numerator_t);
				for (int i = 0; i < back_index; i++) {
					out_t.append(res.get(i));
				}
				out_t.append('(');
				for (int i = back_index; i < res.size(); i++) {
					out_t.append(res.get(i));
				}
				out_t.append(')');
			}
		}
		return out_t.toString();
	}

	public static void main(String[] args) {
		int num_in1 = 10, num_in2 = 3;
		Solution test = new Solution();
		System.out.println(test.fractionToDecimal(num_in1, num_in2));
		num_in1 = -1;
		num_in2 = 3;
		System.out.println(test.fractionToDecimal(num_in1, num_in2));
		num_in1 = 1;
		num_in2 = 7;
		System.out.println(test.fractionToDecimal(num_in1, num_in2));
		num_in1 = 9;
		num_in2 = 2;
		System.out.println(test.fractionToDecimal(num_in1, num_in2));
		num_in1 = -2147483648;
		num_in2 = -1;
		System.out.println(test.fractionToDecimal(num_in1, num_in2));
	}

}
