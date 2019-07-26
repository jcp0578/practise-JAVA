package convert;

/*
 * title:Z 字形变换
 * time:108ms - 8.59%
 * AC but too slow	
 *
 */
public class Solution {
	public String convert(String s, int numRows) {
		if (s == null)
			return s;
		int len = s.length();
		if (numRows == 1 || len <= numRows)
			return s;
		StringBuilder str_out = new StringBuilder();

		for (int r = 0; r < numRows && r < len; r++) {
			int i = r;
			str_out.append(s.charAt(i));
			while (i < len) {
				if (r == numRows - 1) {
					i += 2 * (numRows - 1);
				} else {
					i += (2 * (numRows - 1 - r));
				}
				if(i >=len)
					continue;
				str_out.append(s.charAt(i));
				if (r == 0) {
					i += 2 * (numRows - 1);
				} else {
					i += 2 * r;
				}
				if(i >=len)
					continue;
				str_out.append(s.charAt(i));
			}
		}
		return str_out.toString();
	}

	public static void main(String[] args) {
		String test_in = "LEETCODEISHIRING";
		int test_num = 3;
		Solution test = new Solution();
		System.out.println(test.convert(test_in, test_num));
	}

}
