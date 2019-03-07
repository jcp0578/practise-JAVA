package fizzBuzz;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * Fizz Buzz
 * 
 * AC 7ms but slow
 * @author JCP
 *
 */
public class Solution {
	public static List<String> fizzBuzz(int n) {
		List<String> out_t = new ArrayList<String>();
		for (Integer i = 1; i <= n; i++) {
			out_t.add(i.toString());
		}
		for (int i = 2; i < n; i += 3) {
			out_t.set(i, "Fizz");
		}
		for (int i = 4; i <n; i += 5) {
			if (out_t.get(i) == "Fizz") {
				out_t.set(i, "FizzBuzz");
			} else {
				out_t.set(i, "Buzz");
			}

		}
		return out_t;
	}

	public static void main(String[] args) {
		int num_in = 5;
		List<String> out = fizzBuzz(num_in);
		for (String str : out) {
			System.out.println(str);
		}

	}
}
