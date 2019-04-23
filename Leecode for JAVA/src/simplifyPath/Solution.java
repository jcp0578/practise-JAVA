package simplifyPath;

import java.util.ArrayList;

/*
 * 简化路径
 * AC
 * 8ms - 98.80%
 * 
 */
public class Solution {
	public String simplifyPath(String path) {
		if (path == null)
			return "/";
		int len = path.length();
		if (len == 0)
			return "/";

		int find_index = 0;
		int save_index = 0;
		ArrayList<String> save = new ArrayList<>();
		save.add("/");
		if (path.charAt(0) == '/') {
			find_index++;
		}

		while (find_index < len) {
			int next = path.indexOf('/', find_index);
			if (next == -1) {
				next = len;
			}
			String temp = path.substring(find_index, next);
			if (temp.equals("")) {
				// do nothing
			} else if (temp.equals(".")) {
				// do nothing
			} else if (temp.equals("..")) {
				if (save_index > 0)
					save_index--;
			} else {
				if (save_index != save.size() - 1)
					save.set(save_index + 1, temp);
				else
					save.add(temp);
				save_index++;
			}
			find_index = next + 1;
		}
		StringBuffer res = new StringBuffer();
		res.append('/');
		for (int i = 1; i <= save_index; i++) {
			res.append(save.get(i));
			if (i != save_index)
				res.append('/');
		}
		return res.toString();

	}

	public static void main(String[] args) {
		String test_in = "home";
		Solution test = new Solution();
		System.out.println(test.simplifyPath(test_in));

	}

}
