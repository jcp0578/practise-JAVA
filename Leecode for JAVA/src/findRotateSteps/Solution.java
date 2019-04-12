package findRotateSteps;

/*
 * 自由之路
 * 遍历法
 *  out time
 */
public class Solution {
	String _ring;
	String _key;
	int ring_len;
	int key_len;
	int out;

	public int findRotateSteps(String ring, String key) {
		if (ring == null || key == null)
			return 0;
		this.key_len = key.length();
		if (this.key_len == 0)
			return 0;
		this.ring_len = ring.length();
		this._ring = ring;
		this._key = key;
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

		while (this._ring.charAt(left) != this._key.charAt(key_index)) {
			left--;
			left_step++;
			if (left < 0)
				left = this.ring_len - 1;
		}
		while (this._ring.charAt(right) != this._key.charAt(key_index)) {
			right++;
			right_step++;
			if (right >= this.ring_len)
				right = 0;
		}
		if (left == right) {
			find(left, key_index + 1, count + Math.min(left_step, right_step) + 1);
		} else {
			find(left, key_index + 1, count + left_step + 1);
			find(right, key_index + 1, count + right_step + 1);
		}

			
	}

	public static void main(String[] args) {
		String test_ring = "bicligfijg";
		String test_key = "cgijcjlgiggigigijiiciicjilicjflccgilcflijgigbiifiggigiggibbjbijlbcifjlblfggiibjgblgfiiifgbiiciffgbfl";
		Solution test = new Solution();
		System.out.println(test.findRotateSteps(test_ring, test_key));

	}

}
