package longestCommonPrefix;

/*
 * 最长公共前缀
 * 时间复杂度O(N^2)
 * AC 
 * 4ms - 92.41%
 * 
 */
public class Solution {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null)
			return "";
		int len = strs.length;
		if (len == 0)
			return "";
		StringBuffer out = new StringBuffer();
		for (int j = 0;; j++) {
			try {
				char temp = strs[0].charAt(j);
				int i = 1;
				for (; i < len; i++) {
					if (strs[i].charAt(j) == temp)
						continue;
					else
						break;
				}
				if (i == len) {
					out.append(temp);
				} else
					break;
			} catch (StringIndexOutOfBoundsException e) {
				break;
			} catch (Exception e) {
				e.printStackTrace(System.out);
				break;
			}
		}
		return out.toString();
	}

	public static void main(String[] args) {
		String[] test_in = { "flower", "f", "flight" };
		Solution test = new Solution();
		System.out.println(test.longestCommonPrefix(test_in));
	}

}
