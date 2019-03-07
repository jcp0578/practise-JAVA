package myAtoi;

class Solution {
	public int myAtoi(String str) {
		long out_t = 0;
		int start_flag = 0;
		int pos_flag = 0;
		for (int i = 0; i < str.length(); i++) {
			char temp = str.charAt(i);
			if (start_flag == 0) {
				if (temp == ' ') {
					continue;
				} else if (Character.isDigit(temp)) {
					pos_flag = 1;
					start_flag = 1;
					out_t = out_t * 10 + (temp - '0');
				} else if (temp == '+') {
					pos_flag = 1;
					start_flag = 1;
				} else if (temp == '-') {
					pos_flag = -1;
					start_flag = 1;
				} else {
					return 0;
				}
			} else {
				if (Character.isDigit(temp)) {
					out_t = out_t * 10 + (temp - '0');
					if (out_t >= 2147483647 && pos_flag == 1) {
						return 2147483647;
					}
					if (out_t > 2147483647 && pos_flag == -1) {
						return -2147483648;
					}
				} else {
					break;
				}
			}
		}
		out_t = out_t * pos_flag;
		return (int) out_t;
	}
}