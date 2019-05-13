package reverseVowels;

/*
 * 反转字符串中的元音字母
 * AC
 * 11ms - 50.83%
 * 
 */
public class Solution {
	public String reverseVowels(String s) {
		if (s == null)
			return s;
		int len = s.length();
		String match = "aeiouAEIOU";
		StringBuffer res = new StringBuffer(s);
		int l = 0;
		int r = len - 1;
		while (l < r) {
			while (l < len && match.indexOf(s.charAt(l)) == -1) {
				l++;
			}
			while (r >= 0 && match.indexOf(s.charAt(r)) == -1) {
				r--;
			}
			if (r <= l)
				break;
			else {
				char temp = s.charAt(l);
				res.setCharAt(l, s.charAt(r));
				res.setCharAt(r, temp);
				l++;
				r--;
			}
		}

		return res.toString();
	}

	public static void main(String[] args) {
		String test_in = "race car";
		Solution test = new Solution();
		System.out.println(test.reverseVowels(test_in));
	}

}
