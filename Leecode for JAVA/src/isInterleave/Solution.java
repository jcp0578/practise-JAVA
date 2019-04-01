package isInterleave;

/*
 * 交错字符串
 * error
 * 存在bug
 */
public class Solution {
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s3.length() != (s1.length() + s2.length()))
			return false;

		int s1_i = 0, s2_i = 0, s3_i = 0;
		while (s1_i < s1.length() && s2_i < s2.length() && s3_i < s3.length()) {
			if (s1.charAt(s1_i) == s3.charAt(s3_i)) {
				s1_i++;
				s3_i++;
			} else if (s2.charAt(s2_i) == s3.charAt(s3_i)) {
				s2_i++;
				s3_i++;
			} else
				return false;
		}
		if (s1_i == s1.length() && s2_i == s2.length() && s3_i == s3.length())
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		Solution test = new Solution();
		System.out.println(test.isInterleave(s1, s2, s3));

	}

}
