package findRotateSteps;

import java.util.ArrayList;

/*
 * 自由之路
 * 遍历法 
 * 加入二分搜索查找
 *  out time
 */
public class Solution {
	String _ring;
	String _key;
	int ring_len;
	int key_len;
	int out;
	ArrayList<ArrayList<Integer>> _index;

	public int findRotateSteps(String ring, String key) {
		if (ring == null || key == null)
			return 0;
		this.key_len = key.length();
		if (this.key_len == 0)
			return 0;
		this.ring_len = ring.length();
		this._ring = ring;
		this._key = key;

		this._index = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < 26; i++)
			this._index.add(new ArrayList<Integer>());
		for (int i = 0; i < this.ring_len; i++) {
			this._index.get(ring.charAt(i) - 'a').add(i);
		}

		this.out = Integer.MAX_VALUE;
		find(0, 0, 0);
		return this.out;
	}

	private void find(int ring_index, int key_index, int count) {
		if (key_index == this.key_len) {
			if (this.out > count)
				this.out = count;
			return;
		}
		if (count > this.out)
			return;

		int left = ring_index;
		int right = ring_index;
		int left_step = 0;
		int right_step = 0;

		left = find_index(ring_index, this._key.charAt(key_index), 0);
		if (left <= ring_index)
			left_step = ring_index - left;
		else
			left_step is.ring_len - left + ring_index;

		right = find_index(ring_index, this._key.charAt(key_index), 1);

		if (right >= ring_index)
			right_step = right - ring_index;
		else
			right_step = this.ring_len - ring_index + right;

		if (left == right) {
			find(left, key_index + 1, count + Math.min(left_step, right_step) + 1);
		} else {
			find(left, key_index + 1, count + left_step + 1);
			find(right, key_index + 1, count + right_step + 1);
		}

	}

	private int find_index(int ring_index, char ch, int mode) {
		ArrayList<Integer> list = this._index.get(ch - 'a');
		int len = list.size();
		if (len == 0)
			return -1;
		else if (len == 1)
			return list.get(0);
		if (mode == 0) {
			if (ring_index < list.get(0))
				return list.get(len - 1);
			else if (ring_index > list.get(len - 1))
				return list.get(len - 1);
			else {
				int l = 0;
				int r = len - 1;
				int mid;
				while (l < r) {
					mid = (l + r + 1) >> 1;
					if (list.get(mid) > ring_index) {
						r = mid - 1;
					} else {
						l = mid;
					}
				}
				return list.get(l);
			}
		} else {
			if (ring_index < list.get(0))
				return list.get(0);
			else if (ring_index > list.get(len - 1))
				return list.get(0);
			else {
				int l = 0;
				int r = len - 1;
				int mid;
				while (l < r) {
					mid = (l + r) >> 1;
					if (list.get(mid) < ring_index) {
						l = mid + 1;
					} else {
						r = mid;
					}
				}
				return list.get(r);
			}
		}
	}

	public static void main(String[] args) {
		String test_ring = "bicligfijg";
		String test_key = "j";//"cgijcjlgiggigigijiiciicjilicjflccgilcflijgigbiifiggigiggibbjbijlbcifjlblfggiibjgblgfiiifgbiiciffgbfl";
		Solution test = new Solution();
		System.out.println(test.findRotateSteps(test_ring, test_key));

	}

}
