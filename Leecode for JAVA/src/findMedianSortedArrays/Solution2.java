package findMedianSortedArrays;
/*
 * 排序检索
 * o(m+n)
 */
public class Solution2 {
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int len1, len2;
		len1 = nums1.length;
		len2 = nums2.length;
		int len = len1 + len2;
		if (len == 0) {
			return 0.0;
		}
		int i = 0, j = 0, k = 0;
		int get_num_index1 = (len + 1) / 2;
		int get_num_index2 = (len) / 2 + 1;
		int[] get_num = { 0, 0 };
		int num_temp;
		while (k < len) {
			try {
				if (nums1[i] < nums2[j])
					num_temp = nums1[i++];
				else
					num_temp = nums2[j++];
				k++;
				if ((k) == get_num_index1)
					get_num[0] = num_temp;
				if ((k) == get_num_index2) {
					get_num[1] = num_temp;
					break;
				}
			} catch (Exception e) {
				if (i == len1) {
					if(get_num_index1>k)
						get_num[0] = nums2[j + (get_num_index1 - k)-1];
					if(get_num_index2>k)
						get_num[1] = nums2[j + (get_num_index2 - k)-1];
					break;
				} else {
					if(get_num_index1>k)
						get_num[0] = nums1[i + (get_num_index1 - k)-1];
					if(get_num_index2>k)
						get_num[1] = nums1[i + (get_num_index2 - k)-1];
					break;
				}
			}
		}
		return (get_num[0] + get_num[1]) / 2.0;
	}

	public static void main(String[] args) {
		int[] num_in = {1,3,3};
		int[] num_in2 ={1,2,3};
		System.out.println(findMedianSortedArrays(num_in, num_in2));
	}
}
