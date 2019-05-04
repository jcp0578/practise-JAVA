package removeInvalidParentheses;

/*
 * 删除无效的括号
 * 回溯法
 * AC but slow
 * 89ms - 25.16%
 * 
 */
import java.util.ArrayList;
import java.util.List;

public class Solution {
	int del_min;
	List<String> out;

	public List<String> removeInvalidParentheses(String s) {
		this.out = new ArrayList<>();
		if (s == null)
			return this.out;
		int count = 0;
		int del_num = 0;
		this.del_min = s.length();
		StringBuffer temp = new StringBuffer();
		Deal(s, 0, temp, count, del_num, out);
		return this.out;
	}

	private void Deal(String s, int k, StringBuffer temp, int count, int del_num, List<String> out) {
		if (k == s.length()) {
			if (count == 0) {
				if (del_num == this.del_min) {
					String add_t = temp.toString();
					if (out.indexOf(add_t) == -1)
						out.add(temp.toString());
				} else if (del_num < this.del_min) {
					out.clear();
					out.add(temp.toString());
					this.del_min = del_num;
				} else
					return;
			} else
				return;
		} else {
			if (del_num > this.del_min)
				return;
			if (s.charAt(k) == '(') {
				// ɾ��������
				Deal(s, k + 1, temp, count, del_num + 1, out);

				// ��ɾ��������
				temp.append('(');
				Deal(s, k + 1, temp, count + 1, del_num, out);
				temp.deleteCharAt(temp.length() - 1);

			} else if (s.charAt(k) == ')') {
				// ɾ����)��
				Deal(s, k + 1, temp, count, del_num + 1, out);
				if (count > 0) {
					// ��ɾ����)��
					temp.append(')');
					Deal(s, k + 1, temp, count - 1, del_num, out);
					temp.deleteCharAt(temp.length() - 1);
				}
			} else {
				temp.append(s.charAt(k));
				Deal(s, k + 1, temp, count, del_num, out);
				temp.deleteCharAt(temp.length() - 1);
			}
		}
	}

	public static void main(String[] args) {
		String test_in = ")(";
		Solution test = new Solution();
		System.out.println(test.removeInvalidParentheses(test_in));

	}

}
