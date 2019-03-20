package partition;

import java.util.List;
import java.util.ArrayList;

/*
 * 分割回文串
 * DFS
 * AC but slow
 * 13ms 51.48%
 * 
 */
public class Solution {
	List<List<String>> ret;

	public List<List<String>> partition(String s) {
		ret = new ArrayList<>();
		int len = s.length();
		ArrayList<String> add_t = new ArrayList<>();
		dsp(add_t, s, 0, len);
		return ret;
	}

	private void dsp(ArrayList<String> add_t, String s, int start, int end) {
		if (start == end) {
			ArrayList<String> add = new ArrayList<>(add_t);
			ret.add(add);
			return;
		}
		for (int i = start + 1; i <= end; i++) {
			String head_t = s.substring(start, i);
			if (ispartition(head_t)) {
				add_t.add(head_t);
				dsp(add_t, s, i, end);
				add_t.remove(add_t.size()-1);
			} else {
			}
		}

	}

	private boolean ispartition(String s) {
		int len = s.length();
		int i = 0;
		int j = len - 1;
		while (i <= j) {
			if (s.charAt(i) == s.charAt(j)) {
				i++;
				j--;
			} else
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		String test_str = "cbbbccc";
		System.out.println(test.partition(test_str));
	}

}
