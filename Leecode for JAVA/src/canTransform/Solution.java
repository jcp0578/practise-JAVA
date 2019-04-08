package canTransform;

/*
 * 在LR字符串中交换相邻字符
 * AC
 * 6ms - 100%
 * 
 */
public class Solution {
	public boolean canTransform(String start, String end) {
		if (start == null || end == null)
			return false;
		if (start.length() != end.length())
			return false;
		int len = start.length();
		int i = 0, j = 0;
		while (i < len || j < len) {
			try {
				while (i < len && start.charAt(i) == 'X')
					i++;
				while (j < len && end.charAt(j) == 'X')
					j++;
				if (i < len && j < len) {
					if (start.charAt(i) != end.charAt(j))
						return false;
					else {
						if (start.charAt(i) == 'R') {
							if (i > j)
								return false;
						} else {
							if (i < j)
								return false;
						}
						i++;
						j++;
					}
				} else if (i == len && j == len) {
					return true;
				} else {
					return false;
				}
			} catch (Exception e) {
				e.printStackTrace(System.out);
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String test_start = "XXRXXLXXXX";
		String test_end = "XRXXXXLXXX";
		Solution test = new Solution();
		System.out.println(test.canTransform(test_start, test_end));

	}

}
