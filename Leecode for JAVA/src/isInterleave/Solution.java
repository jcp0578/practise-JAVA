package isInterleave;

/*
 * 交错字符串
 * 递归
 * out time
 * 
 */
public class Solution {
	String _s1;
	String _s2;
	String _s3;

	public boolean isInterleave(String s1, String s2, String s3) {
		if (s3.length() != (s1.length() + s2.length()))
			return false;
		this._s1 = s1;
		this._s2 = s2;
		this._s3 = s3;

		int s1_i = 0, s2_i = 0, s3_i = 0;

		return find(s1_i, s2_i, s3_i);

	}

	private boolean find(int s1_i, int s2_i, int s3_i) {
		if (s3_i == this._s3.length())
			return true;
		if (s1_i == this._s1.length()) {
			return this._s3.substring(s3_i).equals(this._s2.substring(s2_i));
		}
		if (s2_i == this._s2.length()) {
			return this._s3.substring(s3_i).equals(this._s1.substring(s1_i));
		}
		if (this._s1.charAt(s1_i) == this._s2.charAt(s2_i)) {
			if (this._s1.charAt(s1_i) == this._s3.charAt(s3_i)) {
				return (this.find(s1_i + 1, s2_i, s3_i + 1) | this.find(s1_i, s2_i + 1, s3_i + 1));
			} else
				return false;
		} else if (this._s1.charAt(s1_i) == this._s3.charAt(s3_i)) {
			return this.find(s1_i + 1, s2_i, s3_i + 1);
		} else if (this._s2.charAt(s2_i) == this._s3.charAt(s3_i)) {
			return this.find(s1_i, s2_i + 1, s3_i + 1);
		} else
			return false;
	}

	public static void main(String[] args) {
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbbaccc";
		Solution test = new Solution();
		System.out.println(test.isInterleave(s1, s2, s3));

	}

}
