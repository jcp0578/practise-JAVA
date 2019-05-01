package fullJustify;

import java.util.ArrayList;
import java.util.List;

/*
 * 文本左右对齐
 * AC but slow
 * 3ms - 11.43%
 * 
 */
public class Solution {
	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> ret = new ArrayList<String>();
		List<String> add_t = null;
		int add_len = maxWidth + 1;
		for (String t : words) {
			if (t.length() + 1 + add_len > maxWidth) {
				if (add_t != null) {
					ret.add(fullString(add_t, maxWidth, add_len));
				}
				add_t = new ArrayList<String>();
				add_t.add(t);
				add_len = t.length();
			} else {
				add_t.add(" ");
				add_t.add(t);
				add_len += t.length() + 1;
			}
		}
		if (add_t != null && add_t.size() > 0) {
			StringBuffer out = new StringBuffer();
			for (String t : add_t) {
				out.append(t);
			}
			while(out.length()<maxWidth)
				out.append(' ');
			ret.add(out.toString());
		}
		return ret;
	}

	private String fullString(List<String> add_t, int maxWidth, int add_len) {
		if (add_len != maxWidth) {
			int i = 0;
			int len = add_t.size();
			if (len == 1) {
				add_t.add(" ");
				len++;
				add_len++;
			}
			while (add_len < maxWidth) {
				if (add_t.get(i).charAt(0) == ' ') {
					add_t.set(i, add_t.get(i).concat(" "));
					add_len++;
				}
				i++;
				if (i == len)
					i = 0;
			}
		}
		StringBuffer out = new StringBuffer();
		for (String t : add_t) {
			out.append(t);
		}
		return out.toString();
	}

	public static void main(String[] args) {
		String[] test_in = { "Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a",
				"computer.", "Art", "is", "everything", "else", "we", "do" };
		int maxWidth = 20;
		Solution test = new Solution();
		System.out.println(test.fullJustify(test_in, maxWidth));

	}

}
