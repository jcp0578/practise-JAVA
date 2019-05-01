package compareVersion;

/*
 * 比较版本号
 * AC but slow
 * 4ms - 46.54%
 * 
 */
public class Solution {
	public int compareVersion(String version1, String version2) {
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");
		int i = 0;
		int flag = 1;
		if (v1.length > v2.length) {
			String[] t = v1;
			v1 = v2;
			v2 = t;
			flag = -1;
		}
		while (i < v2.length) {
			if (i < v1.length) {
				if (Integer.parseInt(v1[i]) == Integer.parseInt(v2[i]))
					i++;
				else if (Integer.parseInt(v1[i]) > Integer.parseInt(v2[i]))
					return flag;
				else
					return -flag;
			} else {
				if (Integer.parseInt(v2[i]) == 0)
					i++;
				else if (Integer.parseInt(v2[i]) > 0)
					return -flag;
				else
					return flag;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		String s1 = "1.1.0.1";
		String s2 = "1.1.2";
		Solution test = new Solution();
		System.out.println(test.compareVersion(s1, s2));
	}

}
