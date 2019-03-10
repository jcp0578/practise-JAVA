package largestNumber;

import java.util.Arrays;
import java.util.Comparator;

import org.omg.CORBA.PUBLIC_MEMBER;

/*
 * 最大数
 * https://leetcode-cn.com/explore/interview/card/top-interview-quesitons-in-2018/270/sort-search/1169/
 * 
 * 利用Array.sort(),自定义排序函数
 * AC 25ms 82.83%
 */
public class Solution {
	public static String largestNumber(int[] nums) {
		int len = nums.length;
		if (len == 0)
			return "0";

		String[] temp_num = new String[len];
		for (int i = 0; i < len; i++) {
			temp_num[i] = String.valueOf(nums[i]);
		}

		Arrays.sort(temp_num, new Comparator<String>() {
			public int compare(String str1, String str2) {
				int str1_len = str1.length();
				int str2_len = str2.length();
				int i = 0;
				for (i = 0; i < str1_len && i < str2_len; i++) {
					if (str1.charAt(i) > str2.charAt(i))
						return -1;
					else if (str1.charAt(i) < str2.charAt(i))
						return 1;
					else {
					}
				}
				if (i == str1_len && i == str2_len)
					return 0;
				else if (i == str1_len)
					return compare(str1, str2.substring(i, str2_len));
				else if (i == str2_len)
					return compare(str1.substring(i, str1_len), str2);
				else {
				}
				return 0;
			}
		});
		StringBuilder out = new StringBuilder();
		for (String num : temp_num) {
			out.append(num.toString());
		}
		if (out.charAt(0) == '0')
			return "0";
		return out.toString();
	}

	public static void main(String[] args) {
		int[] num_in = { 3, 30, 34, 5, 9 };
		System.out.print(largestNumber(num_in));

	}

}
