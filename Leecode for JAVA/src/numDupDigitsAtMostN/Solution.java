package numDupDigitsAtMostN;


/**
 * 1015. 至少有 1 位重复的数字
 * https://leetcode-cn.com/problems/numbers-with-repeated-digits/submissions/
 * AC but too slow
 * @author JCP
 *
 */
public class Solution {
	int find_N=0;
    public int numDupDigitsAtMostN(int N) {
    	find_N=N;
    	return N+1-numBoDupDigit(0,0);
    }
	private int numBoDupDigit(int mask, long num) {
		if(num>find_N)
			return 0;
		int out=1;
		for(long i=((num==0)?1:0);i<10;i++)
		{
			if(((mask>>i)&1)==0)
			{
				out+=numBoDupDigit(mask|(1<<i),num*10+i);
			}
		}
		return out;
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int num_in=221518701;
		Solution test=new Solution();
		System.out.println(test.numDupDigitsAtMostN(num_in));
	}
}
