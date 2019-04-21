package reverseWords;

/*
 * 翻转字符串里的单词
 * AC
 * 4ms - 94.34%
 * 
 */
public class Solution {
	public String reverseWords(String s) {
		String[] temp = s.split(" ");
		int len = temp.length;
		StringBuffer out = new StringBuffer();
		for (int i = len - 1; i >= 0; i--) {
			if (temp[i].equals(""))
				continue;
			out.append(temp[i]);
			out.append(" ");
		}
		int len_out = out.length();

		if (len_out > 0)
			return out.substring(0, len_out - 1).toString();
		else
			return "";
	}

	public static void main(String[] args) {
		String test_in = "  ";
		Solution test = new Solution();
		System.out.println(test.reverseWords(test_in));

	}

}
