package calculate;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * 基本计算器 II
 * AC but not best
 * 36ms - 57.24%
 * 
 */
public class Solution {
	String _s;
	int _index = 0;
	int s_len = 0;

	int NextNum() {
		int temp = 0;
		int i = this._index;
		for (; i < this.s_len; i++) {
			int t = this._s.charAt(i);
			if (t == ' ')
				continue;
			else if (t >= '0' & t <= '9') {
				temp = temp * 10 + t - '0';
			} else {
				break;
			}
		}
		this._index = i;
		return temp;
	}

	/*
	 * @1 +
	 * 
	 * @2 -
	 * 
	 * @3 *
	 * 
	 * @4 /
	 */
	int NextOp() {
		int i = this._index;
		for (; i < this.s_len; i++) {
			char t = this._s.charAt(i);
			if (t == ' ')
				continue;
			else if (t == '+') {
				this._index = i + 1;
				return 1;
			} else if (t == '-') {
				this._index = i + 1;
				return 2;
			} else if (t == '*') {
				this._index = i + 1;
				return 3;
			} else if (t == '/') {
				this._index = i + 1;
				return 4;
			} else {
				this._index = i;
				break;
			}
		}
		this._index = i;
		return 0;
	}

	public int calculate(String s) {
		this._s = s;
		this.s_len = s.length();
		Deque<Integer> operands = new ArrayDeque<>();
		Deque<Integer> operator = new ArrayDeque<>();
		int last_num = NextNum();
		int op_t;
		while (this._index < this.s_len) {
			op_t = NextOp();
			if (op_t == 1 || op_t == 2) {
				operands.offer(last_num);
				operator.offer(op_t);
				last_num = NextNum();
			} else if (op_t == 3) {
				int temp_num = NextNum();
				last_num *= temp_num;
			} else if (op_t == 4) {
				int temp_num = NextNum();
				last_num /= temp_num;
			} else {
				// error
			}
		}
		operands.offer(last_num);
		last_num=operands.poll();
		while (operator.isEmpty() == false) {
			op_t = operator.poll();
			if (op_t == 1) {
				last_num += operands.poll();
			} else if (op_t == 2) {
				last_num -= operands.poll();
			} else {
				// error
			}
		}
		return last_num;
	}

	public static void main(String[] args) {
		String test_in = " 1-2*2-3/2";
		Solution test = new Solution();
		System.out.println(test.calculate(test_in));
	}

}
