package restoreIpAddresses;

import java.util.ArrayList;
import java.util.List;

/*
 * 复原IP地址
 * 带剪枝的穷举
 * AC but slow
 * 6ms - 51.01%
 * 
 */
public class Solution {
	List<ArrayList<Integer>> out_temp;
	String _s;
	int len;

	public List<String> restoreIpAddresses(String s) {
		ArrayList<String> res = new ArrayList<String>();
		if (s == null)
			return res;
		this.out_temp = new ArrayList<ArrayList<Integer>>();
		this._s = s;
		this.len = s.length();
		ArrayList<Integer> save_t = new ArrayList<>();
		deal(0, 4, save_t);
		for (int i = 0; i < out_temp.size(); i++) {
			StringBuffer out_t = new StringBuffer();
			for (int j = 0; j < 3; j++) {
				out_t.append(String.valueOf(out_temp.get(i).get(j)));
				out_t.append('.');
			}
			out_t.append(String.valueOf(out_temp.get(i).get(3)));
			res.add(out_t.toString());
		}
		return res;
	}

	private void deal(int start, int k, ArrayList<Integer> save_t) {
		if (start >= this.len)
			return;
		if (k == 1) {
			if (start >= (this.len - 3)) {
				if ((this.len - start) != 1 && this._s.charAt(start) == '0')
					return;
				Integer temp = Integer.valueOf(this._s.substring(start, this.len));
				if (temp >= 0 && temp <= 255) {
					ArrayList<Integer> add_t = new ArrayList<Integer>(save_t);
					add_t.add(temp);
					this.out_temp.add(add_t);
					return;
				} else
					return;
			} else
				return;
		} else {
			for (int i = 1; i < 4; i++) {
				if ((this.len - start - i) < (k - 1) || (this.len - start - i) > (3 * (k - 1))) {
					continue;
				}
				if (i != 1 && this._s.charAt(start) == '0')
					continue;
				Integer temp = Integer.valueOf(this._s.substring(start, start + i));

				if (temp >= 0 && temp <= 255) {
					ArrayList<Integer> add_t = new ArrayList<Integer>(save_t);
					add_t.add(temp);
					deal(start + i, k - 1, add_t);

				} else
					continue;
			}
		}

	}

	public static void main(String[] args) {
		String test_in = "25525511135";
		Solution test = new Solution();
		System.out.println(test.restoreIpAddresses(test_in));

	}

}
