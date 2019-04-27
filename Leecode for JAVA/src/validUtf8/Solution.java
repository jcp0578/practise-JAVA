package validUtf8;

/*
 * UTF-8 编码验证
 * AC
 * 4ms - 86.21%
 * 
 */
public class Solution {
	public boolean validUtf8(int[] data) {
		if (data == null)
			return false;
		int len = data.length;
		int index = 0;
		while (index < len) {
			int cheak_len = 0;
			if ((data[index] & 0x80) == 0)
				cheak_len = 1;
			else {
				if ((data[index] & 0x40) == 0)
					return false;
				else {
					// 2byte ~ 4byte
					if ((data[index] & 0x20) == 0x20) {
						if ((data[index] & 0x10) == 0x10) {
							// 4byte
							if ((data[index] & 0x08) == 0) {
								cheak_len = 4;
							} else
								return false;
						} else {
							// 3byte
							cheak_len = 3;
						}
					} else {
						// 2Byte
						cheak_len = 2;
					}
				}
			}
			if (Deal(data, index, cheak_len))
				index += cheak_len;
			else
				return false;
		}
		return true;

	}

	private boolean Deal(int[] data, int index, int len) {
		if (len == 0)
			System.out.println("error");
		try {
			for (int i = 1; i < len; i++) {
				if ((data[index + i] & 0xc0) == 0x80)
					continue;
				else
					return false;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int[] test_in = { 235, 140, 4 };
		Solution test = new Solution();
		System.out.println(test.validUtf8(test_in));

	}

}
