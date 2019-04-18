package checkInclusion;


/*
 * 字符串的排列
 * 滑窗
 * 利用count[26]统计,比较s2中与s1相同长度的子串是否相同
 * AC 
 * 11ms - 95.38%
 */
public class Solution {
	public boolean checkInclusion(String s1, String s2) {
		if (s1 == null)
			return true;
		if (s2 == null)
			return false;

		int len_s1 = s1.length();
		int len_s2 = s2.length();

		if (len_s1 > len_s2)
			return false;

		int[] count_s1 = new int[26];
		int[] count_s2 = new int[26];

		for (int i = 0; i < len_s1; i++) {
			count_s1[s1.charAt(i) - 'a']++;
		}
		for (int i = 0; i < len_s1; i++) {
			count_s2[s2.charAt(i) - 'a']++;
		}
		if (judge(count_s1, count_s2))
			return true;
		for (int i = len_s1; i < s2.length(); i++) {
			count_s2[s2.charAt(i) - 'a']++;
			count_s2[s2.charAt(i - len_s1) - 'a']--;
			if (judge(count_s1, count_s2))
				return true;
		}
		return false;
	}

	private boolean judge(int[] count_s1, int[] count_s2) {
		for (int i = 0; i < 26; i++) {
			if (count_s1[i] != count_s2[i])
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String test_in1 = "adsasd";
		String test_in2 = "asdasdsadas";
		Solution test = new Solution();
		System.out.println(test.checkInclusion(test_in1, test_in2));

	}

}
