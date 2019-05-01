//package swapWithZero;
//
//public class Solution {
//	/**
//	 * 交换数组里n和0的位置
//	 * 
//	 * @param array 数组
//	 * @param len   数组长度
//	 * @param n     和0交换的数
//	 */
//	// 不要修改以下函数内容
//	public void swapWithZero(int[] array, int len, int n) {
//		Main.SwapWithZero(array, len, n);
//	}
//	// 不要修改以上函数内容
//
//	/**
//	 * 通过调用swapWithZero方法来排
//	 * 
//	 * @param array 存储有[0,n)的数组
//	 * @param len   数组长度
//	 */
//	public void sort(int[] array, int len) {
//		// 完成这个函数
//		if (len == 0 || len == 1)
//			return;
//		swapWithZero(array, len, array[0]);// swap 0 to first
//		for (int i = 1; i < len; i++) {
//			if (array[i] == i)
//				continue;
//			else {
//
//				swapWithZero(array, len, array[i]);// swap array[i] to first
//				int j = i + 1;
//				for (; j < len; j++) {
//					if (array[j] == i)
//						break;
//					else {
//					}
//				}
//				swapWithZero(array, len, array[j]);// swap array[j] to right index
//				swapWithZero(array, len, array[0]);// swap 0 to first
//			}
//		}
//	}
//}
