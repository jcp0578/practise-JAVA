package partition;

import java.util.List;
import java.util.ArrayList;

/*
 * 分割回文串
 * DFS
   *   优化ispartition，减少无用的子字符串的生成
 * AC
 * 7ms 88.13%
 * 
 */
public class Solution {
	List<List<String>> ret;

	public List<List<String>> partition(String s) {
		ret = new ArrayList<>();
		ArrayList<String> add_t = new ArrayList<>();
		DFS(add_t, s, 0);
		return ret;
	}

	private void DFS(ArrayList<String> add_t, String s, int start) {
		if (start >= s.length())
			ret.add(new ArrayList<>(add_t));
		else {
			for (int i = start + 1; i <= s.length(); i++) {
				if (ispartition(s, start, i)) {
					String head_t = s.substring(start, i);
					add_t.add(head_t);
					DFS(add_t, s, i);
					add_t.remove(add_t.size() - 1);
				} else {
				}
			}
		}
	}

	private boolean ispartition(String s, int start, int end) {
		int i = start;
		int j = end - 1;
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
		String test_str = "aaa";
		System.out.println(test.partition(test_str));
	}

}
