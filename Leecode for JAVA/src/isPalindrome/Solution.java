package isPalindrome;

/**
 * 125. 验证回文串
   *   重构
 * AC 
 * 6ms 92.68%
 */
public class Solution {
	public boolean isPalindrome(String s) {
		int len = s.length();
		if (len <= 1)
			return true;
		int i = 0, j = len - 1;
		while (true) {
			if (i >= j)
				return true;
			int start = (int) s.charAt(i);
			if (start >= 'A' && start <= 'Z')
				start += 32;
			if ((start >= 'a' && start <= 'z') || (start >= '0' && start <= '9')) {
				int end = (int) s.charAt(j);
				if (end >= 'A' && end <= 'Z')
					end += 32;
				if ((end >= 'a' && end <= 'z') || (end >= '0' && end <= '9')) {
					if (start != end)
						return false;
					else {
						i++;
						j--;
					}
				} else {
					j--;
				}
			} else {
				i++;
			}
		}
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		String test_str = "A man, a plan, a canal: Panama";
		System.out.println(test.isPalindrome(test_str));
	}

}
