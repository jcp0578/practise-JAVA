package smallestEquivalentString;

/*
 * 2. 按字典序排列最小的等效字符串
 * AC
 * 
 */
public class Solution {
	public String smallestEquivalentString(String A, String B, String S) {
		if (S == null)
			return "";
		if (A == null || B == null)
			return S;
		int len = A.length();
		if (len == 0)
			return S;

		char[] map = new char[26];
		for (int i = 0; i < 26; i++)
			map[i] = (char) ('a' + i);

		for (int i = 0; i < len; i++) {
			char temp_a = map[A.charAt(i)-'a'];
			char temp_b = map[B.charAt(i)-'a'];

			char temp = 'a';
			char new_value = 'a';
			if (temp_a < temp_b) {
				temp = map[temp_b - 'a'];
				map[temp_b - 'a'] = (char) Math.min(map[temp_b - 'a'], map[temp_a - 'a']);
				new_value = map[temp_b - 'a'];

			} else if (temp_a > temp_b) {
				temp = map[temp_a - 'a'];
				map[temp_a - 'a'] = (char) Math.min(map[temp_b - 'a'], map[temp_a - 'a']);
				new_value = map[temp_a - 'a'];
			} else {
				continue;
			}

			if (new_value != temp) {
				for (int j = 0; j < 26; j++) {
					if (map[j] == temp) {
						map[j] = new_value;
					}
				}
			}
		}
		StringBuffer out = new StringBuffer();
		for (int i = 0; i < S.length(); i++) {
			out.append((char) map[S.charAt(i) - 'a']);
		}
		return out.toString();

	}

	public static void main(String[] args) {
//		String test_in1 = "nenneefjelfbkajjmlabiejfkfiidjigdogirrngplqkfpjcnk";
//		String test_in2 = "podnbcmknqbkfdarngigdorlfofcegbbnbkhhgopcofjegqdqd";
//		
//		String test_in3 = "yvqnetdqbqoaejikjgcmmeqcdgvektmppufeoszxquoipoyuxh";
		String test_in1 = "air";
		String test_in2 = "ihh";
		String test_in3 = "h";		
		
		Solution test = new Solution();
		System.out.println(test.smallestEquivalentString(test_in1, test_in2, test_in3));

	}

}
